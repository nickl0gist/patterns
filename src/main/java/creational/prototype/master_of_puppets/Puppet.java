package creational.prototype.master_of_puppets;

/**
 * Created on 03.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class Puppet extends  MasterOfPuppetsUnit{
    private String name = "initialization...";

    public void create(){
        this.name = "Puppet";
    }

    @Override
    public String toString() {
        return "Puppet{" +
                "name='" + name + '\'' +
                '}';
    }


}
