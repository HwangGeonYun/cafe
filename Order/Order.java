package Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {

    private List<OrderItem> items = new ArrayList<OrderItem>();

    private static int OrderCounter = 1;
    private int orderNumber;
    PickUp pickUp;
    Iterator it = items.iterator();

    interface PickUp{
        public abstract void handle();
    }
}
