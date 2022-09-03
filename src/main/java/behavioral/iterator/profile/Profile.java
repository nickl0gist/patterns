package behavioral.iterator.profile;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 02.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Profile of User in social Network.
 */
public class Profile {

    /**
     * Name of current user profile.
     */
    @Getter
    private final String name;

    /**
     * E-mail address of current user profile.
     */
    @Getter
    private final String email;

    /**
     * Map which keeps contact list of current profile.
     * Key stores contact type, value keeps ArrayList of contacts for current contact type.
     */
    private final Map<String, List<String>> contacts = new HashMap<>();

    public Profile(String email, String name, String... contacts) {
        this.name = name;
        this.email = email;

        // Get contact list from set of "friend:email@example.com"
        for (String contact : contacts) {
            String[] parts = contact.split(":");

            String contactType = parts[0];
            String contactEmail = parts[1];

            // If contacts map doesn't have current key in 'contactType', add key and put new ArrayList in value.
            if (!this.contacts.containsKey(contactType)) {
                this.contacts.put(contactType, new ArrayList<>());
            }
            // Get certain group by key 'contactType' and add contact Email to Arraylist.
            this.contacts.get(contactType).add(contactEmail);
        }
    }

    /**
     * Retrieve List of contact depending on given contactType.
     */
    public List<String> getContacts(String contactType) {
        // If there no given group type in Map, add contactType to keys and assign empty ArrayList as value to it.
        if (!this.contacts.containsKey(contactType)) {
            this.contacts.put(contactType, new ArrayList<>());
        }
        return contacts.get(contactType);
    }
}
