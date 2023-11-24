package behavioral_patterns.iterator.social_networks;

import behavioral_patterns.iterator.iterators.ProfileIterator;

// Интерфейс коллекции
public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
