package behavioral.mediator.components;

import behavioral.mediator.mediator.Mediator;
import behavioral.mediator.mediator.Note;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created on 31.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete Component. Components are not linked to each other. Only one way to communicate - using Mediator
 */
@NoArgsConstructor
public class Filter extends JTextField implements Component{
    private Mediator mediator;

    @Setter
    private ListModel listModel;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        String start = getText();
        searchElements(start);
    }

    private void searchElements(String s) {
        if (listModel == null) {
            return;
        }

        // If Search contains empty string, complete listModel will be placed in mediator.
        if (s.equals("")) {
            mediator.setElementsList(listModel);
            return;
        }

        // Buffer list
        ArrayList<Note> notes = new ArrayList<>();

        // Goes through listModel and adds each element to notes.
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add((Note) listModel.getElementAt(i));
        }

        // DefaultListModel which collect elements which contain seraching String "s"
        DefaultListModel<Note> listModel = new DefaultListModel<>();

        for (Note note : notes) {
            if (note.getName().contains(s)) {
                listModel.addElement(note);
            }
        }

        // place filtered elements to Mediator elements.
        mediator.setElementsList(listModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}
