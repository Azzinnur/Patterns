package behavioral_patterns.iterator.iterators;

import behavioral_patterns.iterator.profile.Profile;
import behavioral_patterns.iterator.social_networks.LinkedIn;

import java.util.ArrayList;
import java.util.List;

public class LinkedInIterator implements ProfileIterator{
    private LinkedIn linkedIn;
    private String type;
    private String email;
    private int currentPosition = 0;
    private List<String> emails = new ArrayList<>();
    private List<Profile> profiles = new ArrayList<>();

    // Конструктор итератора, в который передаётся класс-коллекция
    public LinkedInIterator(LinkedIn linkedIn, String type, String email) {
        this.linkedIn = linkedIn;
        this.type = type;
        this.email = email;
    }

    // Ленивая загрузка данных в итераторе, которая начинается при вызове метода hasNext();
    private void lazyLoad() {
        if (emails.isEmpty()) {
            List<String> friendsProfiles = linkedIn.requireProfileFriendsFromSocialNetwork(this.email, this.type, linkedIn);
            for (String profile : friendsProfiles) {
                this.emails.add(profile);
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
    public Profile next() {
        if (!hasNext()) {
            return null;
        }

        String friendEmail = emails.get(currentPosition);
        Profile friendProfile = profiles.get(currentPosition);
        if (friendProfile == null) {
            friendProfile = linkedIn.requireProfileFromSocialNetwork(friendEmail, linkedIn);
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
