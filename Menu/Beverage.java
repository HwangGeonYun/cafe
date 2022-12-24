package Menu;

public class Beverage {
    enum SIZE {TALL, GRANDE, VENTI};
    private String name;
    private String size;
    private int price;

    private String kind;

    public Beverage(String name, String size, String kind) {
        this.name = name;
        this.size = size;
        this.kind = kind;
        getPriceBySize(size);
       // basePriceBykinds();
    }

    public String getName(){
        return name;
    }

    public void getPriceBySize(String size){

        switch(size){
            case "TALL"->price = 4500;
            case "GRANDE" -> price = 5000;
            case "VENTI" -> price = 5500;
        }
    }

    public int getPrice(){
        return price;
    }

    public void sizeTo(String size){
        this.size = size;
        getPriceBySize(size);
    }
    @Override
    public String toString(){
        return "name:"+name + ", size:"+size;
    }
}
