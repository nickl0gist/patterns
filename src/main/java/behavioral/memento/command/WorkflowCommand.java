package behavioral.memento.command;

/**
 * Created on 03.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface WorkflowCommand {

    // performed by Command
    void execute();

    // performed by Memento
    void undo();
}
