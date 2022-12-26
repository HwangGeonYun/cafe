package Menu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

public class MenuFactory {

    //BeverageRepository br = new BeverageRepository();

    /*Map<String ,Integer> kinds = new HashMap<>();
    public static int basePriceBykinds(String kind){
        return kinds.get(kind);
    }

    public void addKinds(String kind, int basePrice){
        kinds.put(kind, basePrice);
    };*/
//menuFactory에서 add를 하는 건 목적에 부합하지않는듯
    /*public void addCreatedMenu(String beverage){
        createMenu(beverage.split(","));
        br.save(beverage);
    }*/


    static public Beverage createMenu(String[] fields){
       return new Beverage(ResourceFile.getKind(fields), ResourceFile.getName(fields)
                                           , ResourceFile.getBasePrice(fields),ResourceFile.getSizeList(fields));
    }

    //menu를 String으로 만드는 건데, 왜 만들었지?

    /*public String menuToString(Beverage beverage){
        String getSizeList = beverage.getSizeList().stream().collect(Collectors.joining(", "));

        if(beverage.getSizeList().size()>1)
                getSizeList = "\""+getSizeList +"\"";

        return beverage.getKind()+","+beverage.getName()+","+beverage.getBasePrice()+","+getSizeList;
    }*/
}
