package behavioral_patterns.iterator.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
    private String name;
    private String email;
    private Map<String, List<String>> contacts = new HashMap<>();

    public Profile(String email, String name, String... contacts) {
        this.email = email;
        this.name = name;

        // Парсит список контактов из таких пар как, например: "друзья:email@gmail.com".
        for (String contact : contacts) {
            String[] parts = contact.split(":");
            String contactType = "друзья";
            String contactEmail;
            if (parts.length == 1) {
                contactEmail = parts[0];
            } else {
                contactType = parts[0];
                contactEmail = parts[1];
            }
            this.contacts.computeIfAbsent(contactType, k -> new ArrayList<>());
            this.contacts.get(contactType).add(contactEmail);
        }

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<String> getContacts(String contactType) {
        this.contacts.computeIfAbsent(contactType, k -> new ArrayList<>());
        return contacts.get(contactType);
    }

}
