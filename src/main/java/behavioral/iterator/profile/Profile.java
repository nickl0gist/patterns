package behavioral.iterator.profile;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 02.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Profile of User in social Network.
 */
public class Profile {
    @Getter
    private final String name;
    @Getter
    private final String email;
    private Map<String, List<String>> contacts = new HashMap<>();

    public Profile(String email, String name, String... contacts) {
        this.name = name;
        this.email = email;

        // Get contact list from set of "friend:email@example.com"
        for (String contact : contacts) {
            String[] parts = contact.split(":");
            String contactType = "friend";
            String contactEmail;
            if (parts.length == 1) {
                contactEmail = parts[0];
            } else {
                contactType = parts[0];
                contactEmail = parts[1];
            }
            // If contacts map doesn't have "friend" key, add key and put new ArrayList in value.
            if (!this.contacts.containsKey(contactType)) {
                this.contacts.put(contactType, new ArrayList<>());
            }
            // Get certain group and add contact Email to Arraylist.
            this.contacts.get(contactType).add(contactEmail);
        }
    }

    public List<String> getContacts(String contactType) {
        // If there no given group type in Map, add contactType to keys and assign empty ArrayList as value to it.
        if (!this.contacts.containsKey(contactType)) {
            this.contacts.put(contactType, new ArrayList<>());
        }
        return contacts.get(contactType);
    }
}
