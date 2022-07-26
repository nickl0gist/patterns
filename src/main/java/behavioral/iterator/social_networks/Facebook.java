package behavioral.iterator.social_networks;

import behavioral.iterator.iterators.FacebookIterator;
import behavioral.iterator.iterators.SocialNetworkIterator;
import behavioral.iterator.profile.Profile;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 02.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Facebook implements SocialNetwork {

    private final List<Profile> profiles;

    public Facebook(List<Profile> cache) {
        if (cache != null) {
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    /**
     * Emulation of network latency of requests to Facebook API.
     */
    public Profile requestProfileFromFacebook(String profileEmail){
        simulateNetworkLatency();
        log.info("Facebook: Loading profile '{}' over the network...", profileEmail);

        return findProfile(profileEmail);
    }

    /**
     * Obtain user Profile based on it's email and contact type.
     */
    public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType) {
        simulateNetworkLatency();
        log.info("Facebook: Loading '{}' list of '{}' over the network...", contactType, profileEmail);
        Profile profile = findProfile(profileEmail);
        if (profile != null) {
            return profile.getContacts(contactType);
        }
        return null;
    }

    /**
     * Finds certain profile by it's e-mail from profiles property if exists.
     */
    private Profile findProfile(String profileEmail) {
        for (Profile profile : profiles) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    /**
     * Create certain iterator by friends group for social Facebook network for certain Profile.
     * @param profileEmail email of profile who contacts will be spammed.
     * @return FacebookIterator for Friends contact type.
     */
    @Override
    public SocialNetworkIterator createFriendsIterator(String profileEmail) {
        return new FacebookIterator(this, "friends", profileEmail);
    }

    /**
     * Create certain iterator by Coworkers group for social Facebook network for certain Profile.
     * @param profileEmail email of profile who contacts will be spammed.
     * @return FacebookIterator for Coworkers contact type.
     */
    @Override
    public SocialNetworkIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this, "coworkers", profileEmail);
    }
}
