package view.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.RepositoryController;
import Menu.*;

import java.util.Iterator;
import java.util.List;

public class ClientView extends JFrame {

    BeverageRepository br;
    RepositoryController rc;

//    GridBagLayout layout = new GridBagLayout();
//    GridBagConstraints gbc;
    MenuKinds menuKinds;
    MenusPanel menusPanel;

    JPanel baskets;


    JButton order = new JButton("주문하기");

    ClientView(){

        setLayout(null);
        br = new BeverageRepository();

        //테스트용
        /*br.addKind("Coffee");
        br.addKind("Blended");
        br.addKind("Teavana");
        br.addKind("icecream");
        br.addKind("cookie");
        br.addKind("bread");*/
        //테스트용 나중에 load protect로 막아야 함
        br.load();
        //br.addKind("Blended");
        //br.addKind("Teavana");



        rc = new RepositoryController(br);
        System.out.println(rc.getBeverageList());

        menusPanel = new MenusPanel(rc);
        menuKinds = new MenuKinds(rc, menusPanel);



        baskets = new JPanel();
        baskets.setSize(800, 200);
        baskets.setLocation(0, 580);
        //baskets.setBackground(Color.BLACK);






        //setLayout(layout);


        /*gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,0,0);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        layout.setConstraints(menuKinds, gbc);

        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 6.0;

        layout.setConstraints(menus, gbc);
*/
        add(menusPanel);


        //gbinsert(menuKinds, 0, 0);
        //gbinsert(menus, 0, 1);
        //gbinsert(baskets, 0, 2);


        order.setSize(200, 100);
        order.setLocation(300, 600);

        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order.setVisible(false);
                menuKinds.setVisible(true);
                menusPanel.setVisible(true);
                baskets.setVisible(true);
  //              setLayout(layout);
            }
        });

        add(menuKinds);
        add(menusPanel);
        add(baskets);
        add(order);

        menuKinds.setVisible(false);
        menusPanel.setVisible(false);
        baskets.setVisible(false);

        setSize(800, 1000);
    }

    /*public void gbinsert(Component c, int gridx, int gridy){
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.NORTH;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        //gbc.gridheight = gridheight;
        //gbc.gridwidth = gridwidth;
        layout.setConstraints(c, gbc);
        this.add(c);
    }*/
}
