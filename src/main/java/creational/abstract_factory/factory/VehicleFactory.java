package creational.abstract_factory.factory;

import creational.abstract_factory.vechicle.Vehicle;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface VehicleFactory {
    void assembleVehicle();
    Vehicle getVehicle();
}
