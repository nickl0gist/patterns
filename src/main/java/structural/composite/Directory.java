package structural.composite;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 18.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Composite element in Composite design pattern
 */
@Slf4j
public class Directory extends File{
    private List<File> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void ls() {
        log.info(getName());
        children.forEach(File::ls);
    }

    @Override
    public void addFile(File file) {
        children.add(file);
    }

    @Override
    public File[] getFiles() {
        return children.toArray(new File[0]);
    }

    @Override
    public boolean removeFile(File file) {
        return children.remove(file);
    }
}
