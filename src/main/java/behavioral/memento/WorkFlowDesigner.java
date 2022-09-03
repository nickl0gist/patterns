package behavioral.memento;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 03.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Originator element of Memento Design PAttern
 */
@Slf4j
public class WorkFlowDesigner {

    @Getter
    private Workflow workflow;

    public void createWorkflow(String name) {
        workflow = new Workflow(name);
    }

    /**
     * Used to obtain Memento object with stored state of current Workflow.
     * @return Memento object.
     */
    public Memento getMemento() {
        if(workflow == null) {
            return new Memento();
        }
        return new Memento(workflow.getSteps(), workflow.getName());
    }

    /**
     * Used to obtain Workflow object with state kept in given Memento.
     * @param memento given Memento object.
     */
    public void setMemento(Memento memento) {
        if(memento.isEmpty()) {
            this.workflow = null;
        } else {
            this.workflow = new Workflow(memento.getName(), memento.getSteps());
        }
    }

    /**
     * Add next step in Workflow
     */
    public void addStep(String step) {
        workflow.addStep(step);
    }

    /**
     * Undo last step from Workflow.
     */
    public void removeStep(String step) {
        workflow.removeStep(step);
    }

    public void print() {
        log.info(String.valueOf(workflow));
    }

    //Memento
    public class Memento {

        private String[] steps;

        private String name;

        private Memento() {
        }

        private Memento(String[] steps, String name) {
            this.steps = steps;
            this.name = name;
        }

        private String[] getSteps() {
            return steps;
        }

        private String getName() {
            return name;
        }

        private boolean isEmpty() {
            return this.getSteps() == null && this.getName() == null;
        }
    }
}
