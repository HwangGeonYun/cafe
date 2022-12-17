package Order;

import Menu.Beverage;

public class OrderItem {

    Beverage beverage;
    int quantity;

    public OrderItem(Beverage beverage, int quantity) {
        this.beverage = beverage;
        this.quantity = quantity;
    }
}

