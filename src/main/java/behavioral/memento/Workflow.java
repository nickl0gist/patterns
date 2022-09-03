package behavioral.memento;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created on 03.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class Workflow {

    // Stores performed steps
    private final LinkedList<String> steps;

    @Getter
    private final String name;

    public Workflow(String name) {
        this.name = name;
        this.steps = new LinkedList<>();
    }

    /**
     * @param steps of Workflow. Initiated LinkedList of object steps is being append by values from given Array steps.
     */
    public Workflow(String name, String... steps) {
        this.name = name;
        this.steps = new LinkedList<>();
        if(steps != null && steps.length > 0) {
            this.steps.addAll(Arrays.asList(steps));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Workflow [name=");
        builder.append(name).append("]\nBEGIN -> ");
        for(String step : steps) {
            builder.append(step).append(" -> ");
        }
        builder.append("END");
        return builder.toString();
    }

    public void addStep(String step) {
        steps.addLast(step);
    }

    public boolean removeStep(String step) {
        return steps.remove(step);
    }

    public String[] getSteps() {
        return steps.toArray(new String[0]);
    }
}
