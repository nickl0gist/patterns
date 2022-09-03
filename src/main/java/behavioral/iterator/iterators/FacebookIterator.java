package behavioral.iterator.iterators;

import behavioral.iterator.profile.Profile;
import behavioral.iterator.social_networks.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 02.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Facebook Iterator implements Iterator interface.
 */
public class FacebookIterator implements SocialNetworkIterator{

    /**
     * Social network Entity.
     */
    private final Facebook facebook;

    /**
     * Type of contacts to be iterated.
     */
    private final String type;

    /**
     * e-mail of given Profile.
     */
    private final String email;
    private int currentPosition = 0;
    private final List<String> emails = new ArrayList<>();
    private final List<Profile> profiles = new ArrayList<>();

    public FacebookIterator(Facebook facebook, String type, String email) {
        this.facebook = facebook;
        this.type = type;
        this.email = email;
    }

    /**
     * For the first time list of e-mails is empty and collection of e-mail is initiated.
     */
    private void lazyLoad() {
        if (emails.isEmpty()) {
            List<String> emailList = facebook.requestProfileFriendsFromFacebook(this.email, this.type);
            for (String e : emailList) {
                this.emails.add(e);
                this.profiles.add(null);
            }
        }
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < emails.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }

        // Obtain friends e-mail from current position of iterator...
        String friendEmail = emails.get(currentPosition);

        // Obtain friends profile from current position of iterator...
        // if no such profile at the position, find it in network and place in profiles set with current position index.
        Profile friendProfile = profiles.get(currentPosition);
        if (friendProfile == null) {
            friendProfile = facebook.requestProfileFromFacebook(friendEmail);
            profiles.set(currentPosition, friendProfile);
        }
        currentPosition++;
        return friendProfile;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
