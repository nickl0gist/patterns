package behavioral.chain_of_responsibility.middleware;

/**
 * Created on 26.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface Middleware {

    /**
     * Subclasses implement here concrete validations. Has to be used in checkNext(...).
     * @param email given email to be checked.
     * @param password given password to be checked.
     * @return whether validation passed.
     */
    boolean check(String email, String password);

    /**
     * Starts validation in next element or ends it once the end is reached.
     * @param email given email to be checked.
     * @param password given password to be checked.
     * @return whether validation passed.
     */
    boolean checkNext(String email, String password);
}
