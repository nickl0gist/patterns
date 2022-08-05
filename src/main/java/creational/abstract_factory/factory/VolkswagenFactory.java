package creational.abstract_factory.factory;

import creational.abstract_factory.vechicle.VolkswagenVehicle;
import creational.abstract_factory.vehicle_units.*;

import java.awt.*;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class VolkswagenFactory implements VehicleFactory{

    private VolkswagenVehicle vw;

    @Override
    public void assembleVehicle() {
        GearBox gearBox = assembleGearBox();
        Body body = assembleBody();
        Engine engine = assembleEngine();
        vw = new VolkswagenVehicle(engine, gearBox, body);

    }

    private Engine assembleEngine() {
        Engine engine = new VolkswagenEngine();
        engine.setType(Engine.FuelType.DIESEL);
        return engine;
    }

    private GearBox assembleGearBox(){
        GearBox gearBox = new VolkswagenGearBox();
        gearBox.setType(GearBox.GearBoxType.MANUAL);
        return gearBox;
    }

    private Body assembleBody(){
        Body body = new VolkswagenBody();
        body.setBody(Body.BodyType.SEDAN);
        body.setColor(Color.BLACK.toString());
        return body;
    }

    @Override
    public VolkswagenVehicle getVehicle() {
        return vw;
    }
}
