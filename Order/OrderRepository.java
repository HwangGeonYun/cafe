package Order;

import Menu.Beverage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private List<Order> orders = new ArrayList<Order>();

    public Iterator<Order> createIterator() {return orders.iterator();}

    public int getSize(){
        return (int) orders.stream().filter(o->o.getIsCompleted()==false).count();
    }
    public void add(Order order){
        orders.add(order);
    }

    public String remainingOrder(){
        return "현재 남은 주문 수:"+getSize()+"\n"+
                "/***order 내역***/\n"+
                orders.stream().filter(o->o.getIsCompleted()==false).map(o->o.toString()).collect(Collectors.joining("\n"));
    }

}
