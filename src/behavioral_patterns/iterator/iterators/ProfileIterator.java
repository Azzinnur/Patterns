package behavioral_patterns.iterator.iterators;

import behavioral_patterns.iterator.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile next();

    void reset();
}
