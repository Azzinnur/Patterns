package behavioral_patterns.iterator.social_networks;

import behavioral_patterns.iterator.iterators.LinkedInIterator;
import behavioral_patterns.iterator.iterators.ProfileIterator;
import behavioral_patterns.iterator.profile.Profile;

import java.util.List;

// Класс-коллекция
public class LinkedIn extends AbstractSocialNetwork{
    public LinkedIn(List<Profile> cache) {
        super(cache);
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new LinkedInIterator(this, "друзья", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new LinkedInIterator(this, "коллеги", profileEmail);
    }

}
