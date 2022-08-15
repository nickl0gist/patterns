package structural.adapter;

/**
 * Created on 15.08.2022
 * Client code which requires Customer interface.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class CardDesigner {
    public String designCard(Customer customer){
        String card = "";
        card += customer.getName();
        card += customer.getDesignation();
        card += customer.getAddress();
        return card;
    }
}
