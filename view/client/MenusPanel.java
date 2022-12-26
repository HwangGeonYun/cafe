package view.client;

import Controller.RepositoryController;
import Menu.BeverageRepository;
import Menu.Beverage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenusPanel extends JPanel implements ActionListener {
    RepositoryController rc;
    List<Beverage> beverageList;

    BeverageHandler beverageHandler;
    JButton[] beverageButtons = new JButton[12];
    MenusPanel(List<Beverage> beverageList, RepositoryController rc){
        this.rc = rc;
        this.beverageList = beverageList;
        beverageHandler = new BeverageHandler(beverageList ,rc);

        setLayout(new GridLayout(3,4));
        for(int i = 0;i<12;i++){
            JButton jButton = new JButton();
            beverageButtons[i] = (jButton);
            add(beverageButtons[i]);
            beverageButtons[i].setVisible(false);
        }


        //setLayout(new GridLayout(3,4));
        setSize(800, 600);
        setLocation(0, 140);
        setBackground(Color.WHITE);
    };
    @Override
    public void actionPerformed(ActionEvent e){
        List<Beverage> beveragesOfKind = beverageList.stream().filter(b->b.getKind().equals(e.getActionCommand())).toList();
        System.out.println(e.getActionCommand());

        for(int i =0;i<12;i++){
            beverageButtons[i].removeActionListener(beverageHandler);
        }
        for(int i = 0;i<12 ;i++){
            if(i<beveragesOfKind.size()) {
                System.out.println(012);
                beverageButtons[i].setText(beveragesOfKind.get(i).getName()); //new JButton(beverageList.get(i).getName());
                beverageButtons[i].setVisible(true);
                beverageButtons[i].addActionListener(beverageHandler);
            }
            else beverageButtons[i].setVisible(false);
        }
    }

    /*public void getMenuOfKind(){
        beverageList = br.getBeverageList().stream().filter(b->b.getKind().equals().toList();
        System.out.println(beverageList.size());

        for(int i = 0;i<12 ;i++){
            if(i<beverageList.size()) {
                beverageButtons[i].setText(beverageList.get(i).getName()); //new JButton(beverageList.get(i).getName());
                beverageButtons[i].setVisible(true);
                beverageButtons[i].addActionListener(new BeverageHandler());
            }
            else beverageButtons[i].setVisible(false);
        }
    }*/
}
