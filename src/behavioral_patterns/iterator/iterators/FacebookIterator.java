package behavioral_patterns.iterator.iterators;

import behavioral_patterns.iterator.profile.Profile;
import behavioral_patterns.iterator.social_networks.Facebook;

import java.util.ArrayList;
import java.util.List;

public class FacebookIterator implements ProfileIterator{
    private Facebook facebook;
    private String type;
    private String email;
    private int currentPosition;
    private List<String> emails = new ArrayList<>();
    private List<Profile> profiles = new ArrayList<>();


    // Конструктор итератора, в который передаётся класс-коллекция
    public FacebookIterator (Facebook facebook, String type, String email) {
        this.facebook = facebook;
        this.type = type;
        this.email = email;
    }

    // Ленивая загрузка данных в итераторе, которая начинается при вызове метода hasNext();
    private  void  lazyLoad() {
        if (emails.isEmpty()) {
            List<String> friendsProfiles = facebook.requireProfileFriendsFromSocialNetwork(this.email, this.type, facebook);
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
            friendProfile = facebook.requireProfileFromSocialNetwork(friendEmail, facebook);
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
