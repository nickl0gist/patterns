package behavioral.command.commands;

import behavioral.command.editor.Editor;

/**
 * Created on 29.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class PasteCommand extends Command {
    public PasteCommand(Editor editor) {
        super(editor);
    }

    /**
     * @return <br>False - if clipboard is null or is empty.
     * <br>True - Takes stored in <code>clipboard</code> value and pastes it in current Caret position.
     */
    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
