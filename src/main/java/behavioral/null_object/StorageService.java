package behavioral.null_object;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created on 12.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <>The class which can be replaced by Null Object
 */
@Slf4j
public class StorageService {
    public void save(Report report) {
        log.info("Writing report out");
        try(PrintWriter writer = new PrintWriter(report.getName()+".txt")) {
            writer.println(report.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
