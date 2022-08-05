package creational.prototype;

import creational.prototype.master_of_puppets.Master;
import creational.prototype.master_of_puppets.Puppet;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 03.08.2022
 * <br>Study of Prototype design pattern.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Puppet puppet1 = new Puppet();
        puppet1.create();

        Puppet puppet2 = (Puppet) puppet1.clone();

        log.info("Puppet: {}", puppet1);
        log.info("Puppet: {}", puppet2);

        Master master = new Master();
        master.create();
        master.addPuppet(puppet1);
        master.addPuppet(puppet2);

        log.info("Master: {}", master);

        //Throws exception "Master is only one!"
        Master master2 = (Master) master.clone();
    }
}
