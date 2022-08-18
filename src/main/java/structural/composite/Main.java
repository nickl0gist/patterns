package structural.composite;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 18.08.2022
 * <br>Study of Composite Design Pattern
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        File root = initDirectoryExample();
        root.ls();
        log.info("Root directory has {} file(s)", root.getFiles().length);
        log.info("--------------------------------");
        File file = createBinaryFile();
        file.ls();
    }

    // Client builds tree using leaf and composites
    private static File initDirectoryExample(){
        File file0 = new BinaryFile("Image.img", 1024L);
        File file1 = new BinaryFile("File1.txt", 1024L);
        Directory innerDirectory = new Directory("Inner Directory");
        innerDirectory.addFile(file0);
        innerDirectory.addFile(file1);

        File file2 = new BinaryFile("TextFile.txt", 2301L);
        File file3 = new BinaryFile("Word.doc", 1587L);

        Directory rootDirectory = new Directory("RootDirectory");
        rootDirectory.addFile(file2);
        rootDirectory.addFile(file3);
        rootDirectory.addFile(innerDirectory);
        return rootDirectory;
    }

    private static File createBinaryFile(){
        return new BinaryFile("ExcelFile.xlsx", 200L);
    }
}
