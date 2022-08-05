package creational.abstract_factory.vehicle_units;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class VolkswagenEngine implements Engine {

    private FuelType fuelType;
    private String status;

    @Override
    public void setType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public FuelType getType() {
        return fuelType;
    }

    @Override
    public void start() {
        this.status = "Started";
    }

    @Override
    public void stop() {
        this.status = "Stopped";
    }

    @Override
    public String getStatus() {
        return status;
    }
}
