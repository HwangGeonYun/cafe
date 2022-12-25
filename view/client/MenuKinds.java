package view.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import Menu.BeverageRepository;

public class MenuKinds extends JPanel implements ActionListener {

    List<String> kindList;
    BeverageRepository br;

    MenusPanel menusPanel;
    GridBagConstraints grid;


    JButton left = new JButton("◀");
    JButton right = new JButton("▶");

    JButton[] buttonList = new JButton[4];
    int kindPageNumber = 0;
    MenuKinds(BeverageRepository br, MenusPanel menusPanel) {
        this.br = br;
        this.menusPanel = menusPanel;

        for(int i = 0;i<4;i++)
            buttonList[i] = new JButton();

        kindList = br.getKindList();

        setSize(800, 100);
        setLocation(0, 20);
        setBackground(Color.WHITE);


        setLayout(null);

        left.setSize(50, 50);
        left.setLocation(10, 25);
        right.setSize(50, 50);
        right.setLocation(725, 25);

        left.addActionListener(this);
        right.addActionListener(this);

        getKindInPage(kindPageNumber);

        //right.setLocation(50, 50);
        add(left);
        add(right);
        left.setEnabled(false);
        if(kindList.size()<=4)
            right.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("◀")) {
            kindPageNumber--;
            if (kindPageNumber == 0){
                left.setEnabled(false);
                right.setEnabled(true);
            }
        }
        else if(e.getActionCommand().equals("▶")){
            kindPageNumber++;
                                                    //kindList가 4개이하일때 rightbutton이 false가 안되어
                                                    //누르고 난뒤, 왼쪽으로 돌아가지를 못하는 버그가 발생해서 추가했는데, 그닥 도움이 안됨
            if(kindPageNumber==kindList.size()/4 || kindList.size()<4) {
                right.setEnabled(false);
                left.setEnabled(true);
            }
        }
        removeAllButtons();
        getKindInPage(kindPageNumber);
    }

    public void getKindInPage(int kindPageNumber){

        int firstKindButton = kindPageNumber*4;
        int buttonNumbers = Math.min(kindList.size()-firstKindButton, 4);

        for(int i = 0;i<buttonNumbers;i++){
            if(i<buttonNumbers) {
                buttonList[i].setText(kindList.get(firstKindButton + i)); // 새로 만드니 바로 업데이트 안됨= new JButton(kindList.get(firstKindButton+i));
                buttonList[i].setSize(150, 50);
                buttonList[i].setLocation(237 + 160 * (i - 1), 25);
                buttonList[i].addActionListener(menusPanel);
                add(buttonList[i]);
                buttonList[i].setVisible(true);
            }
            else buttonList[i].setVisible(false);
        }
    }

    public void removeAllButtons(){
        for(JButton button : buttonList){
            button.setVisible(false);
            remove(button);
        }
    }
}
