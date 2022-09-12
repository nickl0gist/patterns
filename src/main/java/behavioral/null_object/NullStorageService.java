package behavioral.null_object;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 12.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Null Object
 */
@Slf4j
public class NullStorageService extends StorageService{
    @Override
    public void save(Report report) {
        log.info("Null object save method. Doing nothing");
    }
}
