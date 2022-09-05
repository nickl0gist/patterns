package behavioral.observer;

/**
 * Created on 05.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete observer. Observes only total Item price state of the Order. Conditionally set discount based on Item costs amount.
 */
public class PriceObserver implements OrderObserver {
    @Override
    public void updated(Order order) {
        double cost = order.getItemCost();
        if (cost >= 500) {
            order.setDiscount(50);
        } else if (cost >= 200) {
            order.setDiscount(10);
        }
    }
}
