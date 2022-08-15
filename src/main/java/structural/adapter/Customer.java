package structural.adapter;

/**
 * Created on 15.08.2022
 * Target interface required by new Client code in CardDesigner.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface Customer {
    String getName();

    String getDesignation();

    String getAddress();
}
