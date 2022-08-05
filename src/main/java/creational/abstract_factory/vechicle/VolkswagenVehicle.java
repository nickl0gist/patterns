package creational.abstract_factory.vechicle;

import creational.abstract_factory.vehicle_units.Body;
import creational.abstract_factory.vehicle_units.Engine;
import creational.abstract_factory.vehicle_units.GearBox;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class VolkswagenVehicle extends Vehicle{

    private final String brandName = "Volkswagen";

    public VolkswagenVehicle(Engine engine, GearBox gearBox, Body body) {
        super(engine, gearBox, body);
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    @Override
    public String toString() {
        return "Volkswagen {" +
                "body=" + getBodyType() +
                ", engine=" + getEngineType() +
                ", gearBox=" + getGearBoxType() +
                ", color=" + getBodyColor() +
                ", currentGear=" + getCurrentGear() +
                ", gear qty=" + getGearQty() +
                "=-";
    }
}
