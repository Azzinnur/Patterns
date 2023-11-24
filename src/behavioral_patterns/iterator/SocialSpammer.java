package behavioral_patterns.iterator;

import behavioral_patterns.iterator.iterators.ProfileIterator;
import behavioral_patterns.iterator.profile.Profile;
import behavioral_patterns.iterator.social_networks.SocialNetwork;

public class SocialSpammer {
    private SocialNetwork network;
    private ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        System.out.println("\nИтерируемся по друзьям...\n");
        iterator = network.createFriendsIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.next();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        System.out.println("\nИтерируемся по коллегам...\n");
        iterator = network.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.next();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendMessage(String email, String message) {
        System.out.printf("Отправляем сообщение: '%s'. Тело сообщения: '%s'%n", email, message);
    }
}
