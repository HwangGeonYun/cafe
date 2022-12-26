package Controller;

import Menu.Beverage;
import Menu.BeverageRepository;

import java.util.List;

public class RepositoryController {
    BeverageRepository br;

    Beverage b;
    public void loadBeverageList(){
        br.load();
    }
    public List<String> getKindList(){
        return br.getKindList();
    }

    public List<Beverage> getBeverageList(){
        return br.getBeverageList();
    }

    public Beverage findBeverage(String name){
        return getBeverageList().stream().filter(b->b.getName().equals(name)).findFirst().get();
    }


    public RepositoryController(BeverageRepository br) {
        this.br = br;
    }
}
