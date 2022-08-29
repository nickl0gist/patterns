package behavioral.command.commands;

import behavioral.command.editor.Editor;

/**
 * Created on 29.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class CutCommand extends Command{
    public CutCommand(Editor editor) {
        super(editor);
    }

    /**
     * Cuts selected text.
     * @return <br> False - if no text selected.
     * <br> Backups current text. Set selected text into Editors clipboard.
     */
    @Override
    public boolean execute() {
        if (editor.textField.getSelectedText().isEmpty()) return false;

        backup();
        String source = editor.textField.getText();
        editor.clipboard = editor.textField.getSelectedText();
        editor.textField.setText(cutString(source));
        return true;
    }

    /**
     * Excludes <code>source</code> string from text which is currently in Editor.
     * @param source - Given text, selected by User to be cut.
     * @return - String from the current Editors state excluding <code>source</code> string.
     */
    private String cutString(String source) {
        String start = source.substring(0, editor.textField.getSelectionStart()); //from the start of the text till the start position of selected text.
        String end = source.substring(editor.textField.getSelectionEnd()); // from the last position of the selected text till the end.
        return start + end;
    }
}
