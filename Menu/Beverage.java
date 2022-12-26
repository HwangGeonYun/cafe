package Menu;

import java.util.List;
import java.util.Map;

public class Beverage {
    private  String kind;
    private  String name;
    private  int basePrice;
    private  List<String> sizeList;

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

    public Beverage(){

    }

    //관리자용
    Beverage(String kind, String name, int basePrice, List<String> sizeList){
        this.kind = kind;
        this.name = name;
        this.basePrice = basePrice;
        this.sizeList = sizeList;
        //this.priceBySize = priceBySize;
    }
    //소비자가 요청한 음료 객체 생성
    public Beverage(String name, String size){
        Beverage beverage = BeverageRepository.search(name);

        this.kind = beverage.getKind();
        this.name = beverage.getName();
        this.basePrice = beverage.getBasePrice();
        this.sizeList = beverage.getSizeList();
        this.size = size;
        getPriceBySize(size);
        // makeFactory에서 구현을 해볼까?
        /*Beverage copy = repository.getBeverageList().stream()
                .filter(b->b.getName().equals(name)).findFirst().get();

        this.kind = copy.getKind();
        this.name = copy.getName();
        basePrice = copy.getBasePrice();
        sizeList = copy.getSizeList();*/
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
