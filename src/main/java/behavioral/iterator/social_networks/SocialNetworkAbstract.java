package behavioral.iterator.social_networks;

/**
 * Created on 02.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public abstract class SocialNetworkAbstract implements SocialNetwork{

    void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
