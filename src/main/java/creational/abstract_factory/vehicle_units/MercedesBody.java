package creational.abstract_factory.vehicle_units;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class MercedesBody implements Body {

    private BodyType bodyType;
    private String color;

    @Override
    public void setBody(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }
}
