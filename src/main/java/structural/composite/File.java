package structural.composite;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 18.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br>The component base class for composite pattern
 * defines operations applicable both leaf and composite
 */
@Setter
@Getter
public abstract class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public abstract void ls();

    public abstract void addFile(File file);

    public abstract File[] getFiles();

    public abstract boolean removeFile(File file);
}
