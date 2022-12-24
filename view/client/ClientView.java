package view.client;

import javax.swing.*;

public class ClientView extends JFrame {
    JButton order = new JButton("주문하기");

    ClientView(){
        setLayout(null);
        order.setSize(200, 100);
        order.setLocation(300, 600);

        add(order);

        setSize(800, 800);
    }

}
