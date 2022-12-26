package Menu;

import Menu.Beverage;

import java.io.File;
import java.util.*;
import java.io.*;

public class BeverageRepository {

    private static BeverageRepository instance = new BeverageRepository();
    private static List<Beverage> beverageList = new ArrayList<>();

    //나중에 private 걸어야함
    public BeverageRepository(){};

    public static final String[] FILE_HEADER =
            { "kind", "name", "size", "basePrice", "\n" };

    private static String resourceFile = Thread.currentThread().getContextClassLoader().getResource("menuData.csv").getFile();

    private static List<String> kindList = new ArrayList<>();

    //void add(Beverage beverage){beverageList.add(beverage);}

    public static BeverageRepository getInstance() {return instance;}

    public Iterator createIterator(List lists){
        return lists.iterator();
    }
    public void addKind(String kind){
        kindList.add(kind);
    }

    public static void load(){
        try(Scanner scanner = new Scanner(new File(resourceFile))){
            if(scanner.hasNext()) scanner.nextLine();

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                //System.out.println(line.split(",").);
                Beverage b = MenuFactory.createMenu(line.split(","));
                beverageList.add(b);
            }

            kindList = beverageList.stream().map(b->b.getKind()).distinct().toList();
            System.out.println("kindList:"+kindList.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void save(String beverage){
        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fw = new FileWriter(resourceFile,true);
            bw = new BufferedWriter(fw);

            bw.write(beverage);
            bw.newLine();

            bw.close();
            fw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addCreatedMenu(String beverage){
        MenuFactory.createMenu(beverage.split(","));
        save(beverage);
    }


    //테스트용 나중에 지움
    public List<Beverage>getBeverageList(){
        return beverageList;
    }
    public List<String>getKindList(){return kindList;}

    static Beverage search(String name){
        return beverageList.stream().filter(b->b.getName().equals(name)).findFirst().get();
    }

}
