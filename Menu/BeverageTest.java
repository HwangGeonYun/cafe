package Menu;

public class BeverageTest {
    public static void main(String[] args){
        BeverageRepository repository = new BeverageRepository();

        MenuFactory menuFactory = new MenuFactory();
        repository.load();

        repository.getBeverageList().stream().forEach(System.out::println);

        repository.addCreatedMenu("coffee,ame,4500,\"Tall, Venti\"");

        repository.getBeverageList().stream().forEach(System.out::println);

    }

}