package behavioral.chain_of_responsibility.middleware;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 26.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Checks limit of requests per time.
 */
@Slf4j
public class LimitMiddleware extends BasicMiddleware{

    private final int requestPerMinute;
    private int request;
    private long currentTime;

    public LimitMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    /**
     * Allows maximum <b>requestPerMinute</b> login attempts during 60 sec. If this condition is ok passes
     * request to next Handler.
     * @param email to check;
     * @param password to check;
     */
    @Override
    public boolean check(String email, String password) {
        log.info("Current LimitMiddleware... ");
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;
        if (request > requestPerMinute) {
            log.info("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(email, password);
    }
}
