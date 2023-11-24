package behavioral_patterns.iterator.social_networks;

import behavioral_patterns.iterator.iterators.ProfileIterator;
import behavioral_patterns.iterator.profile.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Так как логика классов-коллекций схожа, вынесли её в один общий абстрактный класс.
public abstract class AbstractSocialNetwork implements SocialNetwork {
    private List<Profile> profiles;

    protected AbstractSocialNetwork() {
    }

    protected AbstractSocialNetwork(List<Profile> cache) {
        this.profiles = Objects.requireNonNullElseGet(cache, ArrayList::new);
    }

    public Profile requireProfileFromSocialNetwork(String profileEmail, SocialNetwork socialNetwork) {
        // Симуляция долгого POST запроса к одному из адресов API Facebook.
        simulateNetworkLatency();
        String socialNetworkName = socialNetwork.getClass().getSimpleName();
        System.out.printf("%s: Загружаем профиль '%s' через интернет...%n", socialNetworkName, profileEmail);

        // Возвращаем тестовые данные
        return findProfile(profileEmail);
    }

    public List<String> requireProfileFriendsFromSocialNetwork(String profileEmail, String contactType,
                                                               SocialNetwork socialNetwork) {
        // Симуляция долгого POST запроса к одному из адресов API Facebook.
        simulateNetworkLatency();
        String socialNetworkName = socialNetwork.getClass().getSimpleName();
        System.out.printf("%s: Загружаем список '%s' профиля '%s' через интернет...%n", socialNetworkName,
                contactType, profileEmail);

        // Возвращаем тестовые данные
        Profile profile = findProfile(profileEmail);
        if (profile != null) {
            return profile.getContacts(contactType);
        }
        return null;
    }

    private Profile findProfile(String profileEmail) {
        for (Profile profile : profiles) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
