package Order;

import Menu.Beverage;

public class OrderItem {

    private Beverage beverage;
    private int quantity;

    public Beverage getBeverage(){
        return beverage;
    }

    public void changeSize(String size){
        beverage.sizeTo(size);
    }

    public int getPrice(){
        return beverage.getPrice()*quantity;
    }
    public OrderItem(Beverage beverage, int quantity) {
        this.beverage = beverage;
        this.quantity = quantity;
    }

    public String toString(){
        return beverage + ", quantity:"+quantity;
    }
}

