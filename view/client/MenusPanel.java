package view.client;

import Menu.BeverageRepository;
import Menu.Beverage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenusPanel extends JPanel implements ActionListener {
    BeverageRepository br;

    List<Beverage> beverageList;
    JButton[] beverageButtons = new JButton[12];
    MenusPanel(BeverageRepository br){
        this.br = br;

        setLayout(new GridLayout(3,4));
        for(int i = 0;i<12;i++){
            JButton jButton = new JButton();
            beverageButtons[i] = (jButton);
            add(beverageButtons[i]);
            beverageButtons[i].setVisible(true);
        }
        //setLayout(new GridLayout(3,4));
        setSize(800, 600);
        setLocation(0, 140);
        setBackground(Color.WHITE);
    };
    @Override
    public void actionPerformed(ActionEvent e){
        beverageList = br.getBeverageList().stream().filter(b->b.getKind().equals(e.getActionCommand())).toList();
        System.out.println(beverageList.size());

        for(int i = 0;i<12 ;i++){
            if(i<beverageList.size()) {
                beverageButtons[i].setText(beverageList.get(i).getName()); //new JButton(beverageList.get(i).getName());
                beverageButtons[i].setVisible(true);
                beverageButtons[i].addActionListener(new BeverageHandler());
            }
            else beverageButtons[i].setVisible(false);
        }
    }
}
