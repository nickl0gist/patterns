package behavioral.mediator;

import behavioral.mediator.components.*;
import behavioral.mediator.mediator.Editor;
import behavioral.mediator.mediator.Mediator;

import javax.swing.*;

/**
 * Created on 31.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of Mediator Design Pattern
 */
public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
