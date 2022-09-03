package behavioral.memento.command;

import behavioral.memento.WorkFlowDesigner;

/**
 * Created on 03.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class CreateCommand extends AbstractWorkflowCommand{

    private final String name;

    public CreateCommand(WorkFlowDesigner designer, String name) {
        super(designer);
        this.name = name;
    }

    /**
     * Before a command be executed we get memento from receiver and store it in the command object itself.
     */
    @Override
    public void execute() {
        this.memento = receiver.getMemento();
        receiver.createWorkflow(name);
    }
}
