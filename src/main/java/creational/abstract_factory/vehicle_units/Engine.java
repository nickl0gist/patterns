package creational.abstract_factory.vehicle_units;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface Engine {
    enum FuelType {GAS, DIESEL, ECO}

    void setType(FuelType fuelType);

    FuelType getType();

    void start();

    void stop();

    String getStatus();
}
