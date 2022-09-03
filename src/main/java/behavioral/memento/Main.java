package behavioral.memento;

import behavioral.memento.command.AddStepCommand;
import behavioral.memento.command.CreateCommand;
import behavioral.memento.command.WorkflowCommand;

import java.util.LinkedList;

/**
 * Created on 03.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Memento Design Pattern
 */
public class Main {

    public static void main(String[] args) {
        WorkFlowDesigner designer = new WorkFlowDesigner();
        LinkedList<WorkflowCommand> commands = runCommands(designer);
        designer.print();

        undoLastCommand(commands);
        designer.print();

        undoLastCommand(commands);
        designer.print();

        undoLastCommand(commands);
        designer.print();
    }

    private static void undoLastCommand(LinkedList<WorkflowCommand> commands) {
        if(!commands.isEmpty())
            commands.removeLast().undo();
    }

    private static LinkedList<WorkflowCommand> runCommands(WorkFlowDesigner designer) {
        LinkedList<WorkflowCommand> commands = new LinkedList<>();

        WorkflowCommand cmd = new CreateCommand(designer,"Live Workflow");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer,"Create Live Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer,"Middle Step Live Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer,"Submit Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer,"Application Approved");
        commands.addLast(cmd);
        cmd.execute();

        return commands;
    }
}
