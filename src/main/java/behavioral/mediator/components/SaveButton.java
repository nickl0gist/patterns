package behavioral.mediator.components;

import behavioral.mediator.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created on 31.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete Component. Components are not linked to each other. Only one way to communicate - using Mediator
 */
public class SaveButton extends JButton implements Component{
    private Mediator mediator;

    public SaveButton() {
        super("Save");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.saveChanges();
    }

    @Override
    public String getName() {
        return "SaveButton";
    }
}
