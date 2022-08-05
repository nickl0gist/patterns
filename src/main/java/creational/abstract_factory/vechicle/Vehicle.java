package creational.abstract_factory.vechicle;

import creational.abstract_factory.vehicle_units.Body;
import creational.abstract_factory.vehicle_units.Engine;
import creational.abstract_factory.vehicle_units.GearBox;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public abstract class Vehicle {
    private final Engine engine;
    private final GearBox gearBox;
    private final Body body;

    protected Vehicle(Engine engine, GearBox gearBox, Body body) {
        this.engine = engine;
        this.gearBox = gearBox;
        this.body = body;
    }

    public String getEngineType(){
        return engine.getType().name();
    }

    public String getBodyColor(){
        return body.getColor();
    }

    public int getGearQty() {
        return gearBox.getGearQty();
    }

    public int getCurrentGear() {
        return gearBox.getCurrentGear();
    }

    public String getGearBoxType() {
        return gearBox.getGearBoxType().name();
    }

    public void switchGearUp(){
        gearBox.switchUp();
    }

    public void switchGearDown(){
        gearBox.switchDown();
    }

    public void reverse(){
        gearBox.reverse();
    }

    public String getBodyType(){
        return body.getBodyType().name();
    }

    public void start(){
        engine.start();
    }

    public void stop(){
        engine.stop();
    }

    public abstract String getBrandName();

    public String status(){
        return "Engine is " + engine.getStatus() +
                ". Current gear is " + gearBox.getCurrentGear();
    }
}

