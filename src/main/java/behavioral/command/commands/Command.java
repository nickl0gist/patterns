package behavioral.command.commands;

import behavioral.command.editor.Editor;

/**
 * Created on 29.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public abstract class Command {

    Editor editor;
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    /**
     * Backups current state to <code>backup</code> variable.
     */
    void backup(){
        backup = editor.textField.getText();
    }

    /**
     * Set <code>backup</code> value to current state.
     */
    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}
