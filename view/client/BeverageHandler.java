package view.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;

import Controller.RepositoryController;
import Menu.BeverageRepository;
import Menu.Beverage;
//자바의 정석을 참고하든지 해야 겠다. 할께 자꾸 늘어나는 것만 같다.
public class BeverageHandler extends JFrame implements ActionListener, ItemListener {

    RepositoryController rc;
    Beverage beverage;
    int price;



    List<String> sizeList;
    JLabel bevarageName;
    JPanel sizePanel;

    JRadioButton[] size = new JRadioButton[3];
    JLabel priceLabel;
    JButton create = new JButton("확인");
    JButton cancle = new JButton("취소");
    BeverageHandler(RepositoryController rc){
        this.rc = rc;


        //너무 지저분 수정 필요할 듯

        sizePanel = new JPanel();
        sizePanel.setLayout(new FlowLayout());
        sizePanel.setBackground(Color.WHITE);

        sizePanel.setVisible(true);
        sizePanel.setSize(400, 50);
        sizePanel.setLocation(0, 20);

        size[0] = new JRadioButton("Tall");
        size[1] = new JRadioButton("Grande");
        size[2] = new JRadioButton("Venti");

        for(int i =0;i<size.length;i++){
            sizePanel.add(size[i]);
            size[i].setVisible(true);
        }


        /*for(int i = 0;i<size.length;i++) {
            //size[i] = new JRadioButton(""+i);
            add(size[i]);
        }*/


       // priceLabel.setSize();

        create.setSize(80, 50);
        cancle.setSize(80, 50);
        create.setLocation(60, 100);
        cancle.setLocation(260,100);
        //cancle.setLocation();

        //create.addActionListener();
        cancle.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                    setVisible(false);
            }
        });

        add(sizePanel);
        //add(priceLabel);
        add(create);
        add(cancle);

        Arrays.stream(size).forEach(r-> r.setVisible(true));
        setLayout(null);
        setSize(400, 200);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        beverage = rc.findBeverage(e.getActionCommand());

        //변경 가능한 사이즈만 클릭 할 수 있도록 하려고 하는 거
        for(int i = 0;i<3;i++) {
            size[i].setEnabled(false);
        }

        sizeList = beverage.getSizeList();

        for(String sizeName : sizeList){
            for(int i = 0;i<size.length;i++) {
                if (sizeName.trim().equals(size[i].getText()))
                    size[i].setEnabled(true);
            }
        }


        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        switch(e.getStateChange()){

        }

    }
}
