package behavioral.iterator.spammer;

import behavioral.iterator.iterators.SocialNetworkIterator;
import behavioral.iterator.profile.Profile;
import behavioral.iterator.social_networks.SocialNetwork;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 02.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Spam sending class
 */
@Slf4j
public class SpamSender {
    public final SocialNetwork network;
    public SocialNetworkIterator iterator;

    public SpamSender(SocialNetwork network) {
        this.network = network;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        log.info("Iterating over friends...");
        iterator = network.createFriendsIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        log.info("Iterating over coworkers...");
        iterator = network.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    /**
     * Emulates e-mail spam sending
     */
    public void sendMessage(String email, String message) {
        log.info("Sent message to: {}. Message body:{}", email, message);
    }
}
