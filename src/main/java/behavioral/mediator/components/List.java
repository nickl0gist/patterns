package behavioral.mediator.components;

import behavioral.mediator.mediator.Mediator;
import behavioral.mediator.mediator.Note;

import javax.swing.*;

/**
 * Created on 31.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete Component. Components are not linked to each other. Only one way to communicate - using Mediator
 */
@SuppressWarnings("unchecked")
public class List extends JList implements Component {

    private Mediator mediator;

    private final DefaultListModel LIST_MODEL;

    public List(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        LIST_MODEL.addElement(note);
        int index = LIST_MODEL.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
        mediator.sendToFilter(LIST_MODEL);
    }

    /**
     * Takes index of selected item. Removes selected item from LIST_MODEL by element index.
     * Updates list in Mediator.
     */
    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {
            LIST_MODEL.remove(index);
            mediator.sendToFilter(LIST_MODEL);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public Note getCurrentElement() {
        return (Note)getSelectedValue();
    }

    @Override
    public String getName() {
        return "List";
    }

    /**
     * Runnable class Hide which has to be run in a separate Thread. Once any notes selected in list it hides:
     * titleLabel
     * textLabel
     * title
     * textBox
     * save.
     * And shows label "Add new or select existing note to proceed..."
     */
    private class Hide implements Runnable {
        private List list;

        Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (list.isSelectionEmpty()) {
                    mediator.hideElements(true);
                } else {
                    mediator.hideElements(false);
                }
            }
        }
    }
}
