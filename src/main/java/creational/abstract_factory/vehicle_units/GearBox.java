package creational.abstract_factory.vehicle_units;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface GearBox {
    enum GearBoxType {MANUAL, AUTOMATIC}

    void setType(GearBoxType gearBoxType);

    GearBoxType getGearBoxType();

    void switchDown();

    void switchUp();

    void reverse();

    void neutral();

    int getGearQty();

    int getCurrentGear();
}
