package behavioral.iterator.social_networks;

import behavioral.iterator.iterators.SocialNetworkIterator;

/**
 * Created on 02.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface SocialNetwork {
    SocialNetworkIterator createFriendsIterator(String profileEmail);

    SocialNetworkIterator createCoworkersIterator(String profileEmail);
}
