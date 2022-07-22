package creational.simple_factory.computer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on 22.07.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@NoArgsConstructor
@Setter
@Getter
public class Laptop extends Computer {
    @Override
    public String getTypeName() {
        return "Laptop";
    }
}
