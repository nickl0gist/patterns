package creational.prototype.master_of_puppets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 03.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class Master extends MasterOfPuppetsUnit{
    private String name = "initialization...";
    private List<Puppet> puppetList;

    public void create(){
        this.name = "Master";
        this.puppetList = new ArrayList<>();
    }

    @Override
    public MasterOfPuppetsUnit clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Master is only one!");
    }

    public void addPuppet(Puppet puppet){
        this.puppetList.add(puppet);
    }

    @Override
    public String toString() {
        return "Master{" +
                "name='" + name + '\'' +
                ", puppetList=" + puppetList +
                '}';
    }
}
