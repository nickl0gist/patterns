package creational.abstract_factory.vehicle_units;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class VolkswagenGearBox implements GearBox {

    private final int maxGear = 6;
    private int currentGear = 0;
    private GearBoxType type;

    @Override
    public void setType(GearBoxType gearBoxType) {
        type = GearBoxType.MANUAL;
    }

    @Override
    public GearBoxType getGearBoxType() {
        return type;
    }

    @Override
    public void switchDown() {
        if (currentGear != 0)
            currentGear--;
    }

    @Override
    public void switchUp() {
        if(currentGear != maxGear)
            currentGear++;
    }

    @Override
    public void reverse() {
        currentGear = -1;
    }

    @Override
    public void neutral() {
        currentGear = 0;
    }

    @Override
    public int getGearQty() {
        return maxGear;
    }

    @Override
    public int getCurrentGear() {
        return currentGear;
    }
}
