package creational.abstract_factory;

import creational.abstract_factory.factory.MercedesFactory;
import creational.abstract_factory.vechicle.MercedesVehicle;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 05.08.2022
 * <br> Study of Abstract Factory design pattern.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        MercedesFactory mercedesFactory = new MercedesFactory();
        mercedesFactory.assembleVehicle();
        MercedesVehicle mercedesVehicle = mercedesFactory.getVehicle();
        log.info("Assembled Vehicle: {}", mercedesVehicle);
        mercedesVehicle.start();
        mercedesVehicle.switchGearUp();
        log.info("Mercedes status: {}", mercedesVehicle.status());

        MercedesFactory vwFactory = new MercedesFactory();
        vwFactory.assembleVehicle();
        MercedesVehicle volkswagenVehicle = vwFactory.getVehicle();
        log.info("Assembled Vehicle: {}", volkswagenVehicle);
        volkswagenVehicle.start();
        volkswagenVehicle.switchGearUp();
        volkswagenVehicle.switchGearUp();
        volkswagenVehicle.switchGearUp();
        volkswagenVehicle.reverse();
        log.info("Volkswagen status: {}", volkswagenVehicle.status());
    }
}
