package Order;

import Menu.Beverage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Order {

    private List<OrderItem> items = new ArrayList<OrderItem>();

    private static int OrderCounter = 1;
    private int orderNumber;

    public Order(){
        orderNumber = OrderCounter;
        OrderCounter++;
    }

    private boolean iscompleted = false;
    PickUp pickUp;
    Iterator it = items.iterator();

    public void completed(){
        pickUp.handle(this);
        iscompleted = true;
    }

    public boolean getIsCompleted(){
        return iscompleted;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public void setPickUp(PickUp pickUp){
        this.pickUp = pickUp;
    }

    public void changeSize(String  name, String size){
        items.stream().filter(items->items.getBeverage().getName().equals(name)).forEach(i->i.changeSize(size));
    }

    public int calculatePrice(){

        return items.stream().map(i->i.getPrice()).reduce(Integer::sum).get();
    }
    public void add(Beverage beverage, int quantity){
        items.add(new OrderItem(beverage, quantity));
    }

    public interface PickUp{
        public abstract void handle(Order order);
    }

    public String toString(){
        return items.stream().collect(Collectors.toList()).toString()+"\n"
                +"총 합계금액:" + calculatePrice();
    }
}
