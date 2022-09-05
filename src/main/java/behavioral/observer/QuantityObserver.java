package behavioral.observer;

/**
 * Created on 05.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete observer. Observes only total Item Qty state in the Order. Conditionally set Shipping Cost based on total Item Qty amount.
 */
public class QuantityObserver implements OrderObserver {
    @Override
    public void updated(Order order) {
        int count = order.getItemQty();
        if (count <= 5) {
            order.setShippingCosts(10);
        } else {
            order.setShippingCosts(10 + (count - 5) * 1.5);
        }
    }
}
