package Menu;

import java.util.List;
import java.util.Map;

public class Beverage {
    private final String kind;
    private final String name;
    private final int basePrice;
    private final List<String> sizeList;

    private String size;
    private int price;

    //private Map<String,Integer> priceBySize;

    //소비자용
    /*public Beverage(String name, String size, String kind, int basePrice) {
        this.name = name;
        //this.size = size;
        this.kind = kind;
        this.basePrice = basePrice;
        getPriceBySize(size);
       // basePriceBykinds();
    }*/

    //관리자용
    Beverage(String name, String kind, int basePrice, List<String> sizeList){
        this.name = name;
        this.kind = kind;
        this.basePrice = basePrice;
        this.sizeList = sizeList;
        //this.priceBySize = priceBySize;
    }

    public String getName(){
        return name;
    }

    public String getKind(){return kind;}

    public List<String> getSizeList(){return sizeList;}
    public int getBasePrice(){return basePrice;}
    public void getPriceBySize(String size){

        switch(size){
            case "TALL"-> price = basePrice;
            case "GRANDE" -> price = basePrice+500;
            case "VENTI" -> price = basePrice+1000;
        }
    }

    public int getPrice(){
        return price;
    }

    public void sizeTo(String size){
        this.size = size;
        getPriceBySize(size);
    }
    /*@Override
    public String toString(){
        return "name:"+name + ", size:"+size;
    }*/

    //관리자테스트
    @Override
    public String toString(){
        return "kind:"+kind+", name:"+name+", basePrice:"+basePrice+", sizeList" + getSizeList();
    }
}
