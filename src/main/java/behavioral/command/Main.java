package behavioral.command;

import behavioral.command.editor.Editor;

/**
 * Created on 29.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br>Study of Command Design Pattern by creatin simple text editor.
 */
public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
