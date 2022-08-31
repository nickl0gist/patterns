package behavioral.mediator.components;

import behavioral.mediator.mediator.Mediator;

/**
 * Created on 31.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Common interface for Components
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
