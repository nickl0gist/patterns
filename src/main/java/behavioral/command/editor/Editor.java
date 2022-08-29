package behavioral.command.editor;

import behavioral.command.commands.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 29.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> UI of the Text editor.
 */
public class Editor {
    public JTextArea textField;
    public String clipboard;
    private CommandHistory history = new CommandHistory();

    public void init(){
        // Frame creation
        JFrame frame = new JFrame("Simple text editor.");

        // Panel creation
        JPanel content = new JPanel();

        // Set content into Frame
        frame.setContentPane(content);

        // Add Close button to Frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Sets the layout manager for this container.
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // Create text filed with wrapping it's lines.
        textField = new JTextArea();
        textField.setLineWrap(true);

        // Add text field to container
        content.add(textField);

        // Create button panel and 4 buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");

        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(this)));
        ctrlX.addActionListener(e -> executeCommand(new CutCommand(this)));
        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(this)));
        ctrlZ.addActionListener(e -> undo());

        // Add created buttons into Button pane.
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);

        // Add Button Pane to container
        content.add(buttons);

        // Set frame size
        frame.setSize(450, 200);

        // Sets the location of the window relative to the specified component
        frame.setLocationRelativeTo(null);

        // Set visibility to true.
        frame.setVisible(true);
    }

    /**
     * Of command execution returns true, then keep command in History
     * @param command any command (ctrlC, ctrlX, ctrlV, ctrlZ)
     */
    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    /**
     * Pops up the last command from history and calls <code>undo</code> method on taken command.
     * Doesn't do anything if history is empty.
     */
    private void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}
