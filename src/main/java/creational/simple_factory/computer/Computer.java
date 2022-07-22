package creational.simple_factory.computer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created on 22.07.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@ToString
@Setter
@Getter
public abstract class Computer {
    private String brandName;
    public abstract String getTypeName();
}
