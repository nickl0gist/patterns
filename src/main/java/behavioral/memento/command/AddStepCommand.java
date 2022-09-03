package behavioral.memento.command;

import behavioral.memento.WorkFlowDesigner;

/**
 * Created on 03.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class AddStepCommand extends AbstractWorkflowCommand{

    private final String step;

    public AddStepCommand(WorkFlowDesigner designer, String step) {
        super(designer);
        this.step = step;
    }

    /**
     * Before a command be executed we get memento from receiver and store it in the command object itself.
     */
    @Override
    public void execute() {
        this.memento = receiver.getMemento();
        receiver.addStep(step);
    }
}
