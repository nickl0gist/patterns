package behavioral.mediator.mediator;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 31.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Class for Notes.
 */
@Getter
@Setter
public class Note {
    private String name;
    private String text;

    public Note() {
        name = "New note";
    }

    @Override
    public String toString() {
        return name;
    }
}
