package behavioral.iterator.social_networks;

import behavioral.iterator.iterators.LinkedInIterator;
import behavioral.iterator.iterators.SocialNetworkIterator;
import behavioral.iterator.profile.Profile;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 02.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class LinkedIn implements SocialNetwork {

    private final List<Profile> contacts;

    public LinkedIn(List<Profile> cache) {
        if (cache != null) {
            this.contacts = cache;
        } else {
            this.contacts = new ArrayList<>();
        }
    }

    public Profile requestContactInfoFromLinkedInAPI(String profileEmail) {
        simulateNetworkLatency();
        log.info("LinkedIn: Loading profile '{}' over the network...", profileEmail);

        // ...и возвращаем тестовые данные.
        return findContact(profileEmail);
    }

    public List<String> requestRelatedContactsFromLinkedInAPI(String profileEmail, String contactType) {
        simulateNetworkLatency();
        log.info("LinkedIn: Loading '{}' list of '{}' over the network...", contactType, profileEmail);
        Profile profile = findContact(profileEmail);
        if (profile != null) {
            return profile.getContacts(contactType);
        }
        return null;
    }

    private Profile findContact(String profileEmail) {
        for (Profile profile : contacts) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    @Override
    public SocialNetworkIterator createFriendsIterator(String profileEmail) {
        return new LinkedInIterator(this, "friends", profileEmail);
    }

    @Override
    public SocialNetworkIterator createCoworkersIterator(String profileEmail) {
        return new LinkedInIterator(this, "coworkers", profileEmail);
    }
}
