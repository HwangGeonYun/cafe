import java.util.Iterator;
import java.util.Scanner;

import Menu.Beverage;
import Order.*;

public class OrderTest {
    static PickUpFactory pickUpFactory = new PickUpFactory();

    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();

        orderRepository.add(makeOrderForDelivery());
        orderRepository.add(makeOrderForDriveThru());
        orderRepository.add(makeOrderForTakeOut());

        Iterator<Order> iterator = orderRepository.createIterator();
        while(iterator.hasNext()) {
            System.out.println(orderRepository.remainingOrder());
            Order order = iterator.next();
            order.completed();
        }
    }

    private static Order makeOrderForTakeOut() {
        Order order = new Order();
        Order.PickUp pickUp = pickUpFactory.makePickUpTakeOut();
        order.setPickUp(pickUp);
        order.add(new Beverage("MangoBanana", "TALL", "COFFEE"), 1);
        order.add(new Beverage("Americano", "TALL", "COFFEE"), 1);
        order.changeSize("Chamomile", "GRANDE");
        order.changeSize("Americano", "GRANDE");
        return order;
    }

    private static Order makeOrderForDriveThru() {
        Order order = new Order();
        Order.PickUp pickUp = pickUpFactory.makePickUpDriveThru("001가0000");
        order.setPickUp(pickUp);
        order.add(new Beverage("Americano", "TALL", "COFFEE"), 2);
        order.changeSize("MangoBanana", "TALL");
        return order;
    }

    private static Order makeOrderForDelivery() {
        Order order = new Order();
        Order.PickUp pickUp = pickUpFactory.makePickUpDelivery("Pusan National University");
        order.setPickUp(pickUp);
        order.add(new Beverage("MangoBanana", "TALL", "COFFEE"), 1);
        order.add(new Beverage("Americano", "TALL", "COFFEE"), 1);
        order.changeSize("Americano", "VENTI");
        return order;
    }
}
