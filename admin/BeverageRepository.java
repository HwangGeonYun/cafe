package admin;

import Menu.Beverage;

import java.util.ArrayList;
import java.util.List;

public class BeverageRepository {
    List<Beverage> beverageList = new ArrayList<>();

    void add(Beverage beverage){
        beverageList.add(beverage);
    }

    /*Beverage search(String name){
    }*/
}
