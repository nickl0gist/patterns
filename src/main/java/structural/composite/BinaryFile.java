package structural.composite;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 18.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br/> Leaf node in Composite pattern
 */
@Getter
@Slf4j
public class BinaryFile extends File{
    private final long size;

    public BinaryFile(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public void ls() {
      log.info("{}\t{}", getName(), size);
    }

    @Override
    public void addFile(File file) {
        throw new UnsupportedOperationException("The Leaf Node doesn't support add operation");
    }

    @Override
    public File[] getFiles() {
        throw new UnsupportedOperationException("The Leaf Node doesn't support get operation");
    }

    @Override
    public boolean removeFile(File file) {
        throw new UnsupportedOperationException("The Leaf Node doesn't support remove operation");
    }
}
