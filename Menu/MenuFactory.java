package Menu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

public class MenuFactory {

    BeverageRepository br = new BeverageRepository();

    /*Map<String ,Integer> kinds = new HashMap<>();
    public static int basePriceBykinds(String kind){
        return kinds.get(kind);
    }

    public void addKinds(String kind, int basePrice){
        kinds.put(kind, basePrice);
    };*/

    public void addCreatedMenu(String beverage){
        createMenu(beverage.split(","));
        br.save(beverage);
    }

    static public Beverage createMenu(String[] fields){
       return new Beverage(ResourceFile.getKind(fields), ResourceFile.getName(fields)
                                           , ResourceFile.getBasePrice(fields),ResourceFile.getSizeList(fields));
    }
    public String menuToString(Beverage beverage){
        String getSizeList = beverage.getSizeList().stream().collect(Collectors.joining(", "));

        if(beverage.getSizeList().size()>1)
                getSizeList = "\""+getSizeList +"\"";

        return beverage.getKind()+","+beverage.getName()+","+beverage.getBasePrice()+","+getSizeList;
    }
}
