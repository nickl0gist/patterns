package creational.simple_factory;

import creational.simple_factory.computer.Computer;
import creational.simple_factory.computer.Laptop;
import creational.simple_factory.computer.PC;
import creational.simple_factory.computer.Tablet;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 22.07.2022
 * <br>Study of Simple Factory
 * @author Mykola Horkov
 * <br>mykola.horkov@gmail.com
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        Computer tablet = ComputerFactory.getComputer("Tablet");
        tablet.setBrandName("Samsung");

        Computer pc = ComputerFactory.getComputer("PC");
        pc.setBrandName("HP");

        Computer laptop = ComputerFactory.getComputer("Laptop");
        laptop.setBrandName("Acer");

        log.info(tablet.toString());
        log.info(laptop.toString());
        log.info(pc.toString());
    }
}

class ComputerFactory{
    public static Computer getComputer(String computerType){
        switch (computerType.toLowerCase()){
            case "pc":
                return new PC();
            case "tablet":
                return new Tablet();
            case "laptop":
                return new Laptop();
            default: throw new IllegalArgumentException("No such computer type is available: " + computerType.toLowerCase());
        }
    }

    private ComputerFactory() {
    }
}
