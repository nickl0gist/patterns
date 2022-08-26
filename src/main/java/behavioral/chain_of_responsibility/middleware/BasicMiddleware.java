package behavioral.chain_of_responsibility.middleware;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 26.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public abstract class BasicMiddleware implements Middleware{

    private BasicMiddleware next;

    /**
     * Build of the chain of Handlers.
     * @param head has to become the very first Handler in Chain.
     * @param chain chain of the rest of Handlers.
     * @return built chain.
     */
    public static BasicMiddleware link(BasicMiddleware head, BasicMiddleware... chain){
        BasicMiddleware current = head;
        for (BasicMiddleware nextInChain : chain) {
            current.next = nextInChain;
            current = nextInChain;
        }
        return head;
    }

    @Override
    public boolean checkNext(String email, String password) {
        return next == null || next.check(email, password);
    }
}
