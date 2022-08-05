package creational.abstract_factory.vehicle_units;

/**
 * Created on 05.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface Body {
    enum BodyType{SEDAN, COUPE, SUV}

    void setBody(BodyType bodyType);

    BodyType getBodyType();

    void setColor(String color);

    String getColor();
}
