package creational.abstract_factory.factory;

import creational.abstract_factory.vechicle.MercedesVehicle;
import creational.abstract_factory.vehicle_units.*;

import java.awt.*;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class MercedesFactory implements VehicleFactory{

    private MercedesVehicle mercedes;

    @Override
    public void assembleVehicle() {
        GearBox gearBox = assembleGearBox();
        Body body = assembleBody();
        Engine engine = assembleEngine();
        mercedes = new MercedesVehicle(engine, gearBox, body);

    }

    private Engine assembleEngine() {
        Engine engine = new MercedesEngine();
        engine.setType(Engine.FuelType.ECO);
        return engine;
    }

    private GearBox assembleGearBox(){
        GearBox gearBox = new MercedesGearBox();
        gearBox.setType(GearBox.GearBoxType.AUTOMATIC);
        return gearBox;
    }

    private Body assembleBody(){
        Body body = new MercedesBody();
        body.setBody(Body.BodyType.SUV);
        body.setColor(Color.WHITE.toString());
        return body;
    }

    @Override
    public MercedesVehicle getVehicle() {
        return mercedes;
    }
}
