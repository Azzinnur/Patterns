package behavioral_patterns.iterator.social_networks;

import behavioral_patterns.iterator.iterators.FacebookIterator;
import behavioral_patterns.iterator.iterators.ProfileIterator;
import behavioral_patterns.iterator.profile.Profile;

import java.util.List;

// Класс-коллекция
public class Facebook extends AbstractSocialNetwork {

    public Facebook(List<Profile> cache) {
        super(cache);
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new FacebookIterator(this, "друзья", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this, "коллеги", profileEmail);
    }

}
