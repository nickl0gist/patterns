package behavioral.state;

import behavioral.state.ui.Player;
import behavioral.state.ui.UI;

/**
 * Created on 06.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of State Design Pattern.
 */
public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
