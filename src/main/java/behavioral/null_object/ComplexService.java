package behavioral.null_object;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 12.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class ComplexService {
    private final StorageService storage;

    private final String reportName;

    public ComplexService(StorageService storage) {
        this.storage = storage;
        reportName = "A Complex Report";
    }

    public ComplexService(String reportName, StorageService storage) {
        this.storage = storage;
        this.reportName = reportName;
    }

    public void generateReport() {
        log.info("Starting a complex report build!");

        // Emulation of Execution latency
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("Done with report..");
        storage.save(new Report(reportName));
    }
}
