package behavioral.iterator;

import behavioral.iterator.profile.Profile;
import behavioral.iterator.social_networks.Facebook;
import behavioral.iterator.social_networks.LinkedIn;
import behavioral.iterator.social_networks.SocialNetwork;
import behavioral.iterator.spammer.SpamSender;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 02.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of Iterator Design Pattern.
 */
@Slf4j
public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        log.info("Please specify social network to target spam tool (default:Facebook):");
        log.info("1. Facebook");
        log.info("2. LinkedIn");
        String choice = scanner.nextLine();

        SocialNetwork network;

        // Assign network basing on made choice
        network = choice.equals("2")
                ? new LinkedIn(createTestProfiles())
                : new Facebook(createTestProfiles());

        SpamSender spammer = new SpamSender(network);

        spammer.sendSpamToFriends("spiderman@example.com",
                "Hey! This is Jane's friend Josh. Can you do me a favor and like this post [some_link]?");

        spammer.sendSpamToCoworkers("jane.doe@bing.com",
                "Hey! This is Jane's boss Jason. Anna told me you would be interested in [some_link].");
    }

    /**
     * Static creation of Profiles.
     * @return List of Profiles.
     */
    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<>();
        data.add(new Profile("jane.doe@bing.com", "Jane Doe", "coworkers:mr.anderson@ya.com", "coworkers:halkwoman@ebay.com", "coworkers:spiderman@example.com"));
        data.add(new Profile("mr.anderson@ya.com", "Mr. Anderson", "friends:jane.doe@bing.com", "coworkers:spiderman@example.com"));
        data.add(new Profile("billy@micro.eu", "Billy", "coworkers:x-men@marvel.net"));
        data.add(new Profile("x-men@marvel.net", "Xavier", "coworkers:billy@micro.eu"));
        data.add(new Profile("spiderman@example.com", "Spider Man", "coworkers:jane.doe@bing.com", "coworkers:mr.anderson@ya.com", "friends:halkwoman@ebay.com"));
        data.add(new Profile("halkwoman@ebay.com", "Kelly", "friends:jane.doe@bing.com", "friends:spiderman@example.com"));
        return data;
    }
}
