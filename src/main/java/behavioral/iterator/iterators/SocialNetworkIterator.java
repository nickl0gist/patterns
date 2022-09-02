package behavioral.iterator.iterators;

import behavioral.iterator.profile.Profile;

/**
 * Created on 02.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Interface for profile Iterating.
 */
public interface SocialNetworkIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
