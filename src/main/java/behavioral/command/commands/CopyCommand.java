package behavioral.command.commands;

import behavioral.command.editor.Editor;

/**
 * Created on 29.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br>
 */
public class CopyCommand extends Command{
    public CopyCommand(Editor editor) {
        super(editor);
    }

    /**
     * Stores selected text to Editors clipboard.
     */
    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
