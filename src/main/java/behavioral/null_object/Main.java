package behavioral.null_object;

/**
 * Created on 12.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of null object DP
 */
public class Main {
    public static void main(String[] args) {
        ComplexService service = new ComplexService("Simple report 2",new StorageService());
        service.generateReport(); // Creates "Simple report 2.txt" because StorageService is used.

        service = new ComplexService("Simple report 2",new NullStorageService());
        service.generateReport(); // Does nothing since NullStorageService is used as Null Object
    }
}
