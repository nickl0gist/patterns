package behavioral.memento.command;

import behavioral.memento.WorkFlowDesigner;

/**
 * Created on 03.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public abstract class AbstractWorkflowCommand implements WorkflowCommand{

    protected WorkFlowDesigner.Memento memento;

    protected WorkFlowDesigner receiver;

    protected AbstractWorkflowCommand(WorkFlowDesigner designer) {
        this.receiver = designer;
    }

    @Override
    public void undo() {
        receiver.setMemento(memento);
    }
}
