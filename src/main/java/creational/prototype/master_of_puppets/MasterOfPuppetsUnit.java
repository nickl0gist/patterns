package creational.prototype.master_of_puppets;

/**
 * Created on 03.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public abstract class MasterOfPuppetsUnit implements Cloneable{

    @Override
    public MasterOfPuppetsUnit clone() throws CloneNotSupportedException {
        return (MasterOfPuppetsUnit) super.clone();
    }
}
