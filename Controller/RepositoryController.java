package Controller;

import Menu.Beverage;
import Menu.BeverageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RepositoryController {



    private static String path;
    private static final String baseURL = "http://localhost:9000";

    private static final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    Beverage b;
    /*public void loadBeverageList(){
        br.load();
    }*/
    /*public List<String> getKindList(){
        return br.getKindList();
    }*/
    //swingWorker를 이용하려다 포기
    public List<Beverage> getBeverageList(){
        path = "/Cafes?";
        List<Beverage> beverageList = null;

        ObjectMapper mapper = new ObjectMapper();
       HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(baseURL+path))
               .header("Content-Type", "Application/Json")
               .GET()
               .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("SwingWorker:" +response.body());
            System.out.println(response.statusCode());
            if(response.statusCode() == 200){

                CollectionType ListType = mapper.getTypeFactory().constructCollectionType(List.class, Beverage.class);
                beverageList = mapper.readValue(response.body(), ListType);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(beverageList.size());
        return beverageList;
       //Task task = new Task(request);
       //task.execute();
    }

    //Clent가 쓰는 메소드인데 수정이 필요함, client 팀에게 문의를 해보자
    /*public Beverage findBeverage(String name){
        return getBeverageList().stream().filter(b->b.getName().equals(name)).findFirst().get();
    }*/



     class Task <T> extends SwingWorker<Void, Void>  {
        HttpRequest request;
        ObjectMapper mapper = new ObjectMapper();
        public Void doInBackground(){
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("SwingWorker:" +response.body());

                if(response.statusCode() == 200){

                    CollectionType ListType = mapper.getTypeFactory().constructCollectionType(List.class, Beverage.class);
                    List<Beverage> beverageList = mapper.readValue(response.body(), ListType);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
        public Task(HttpRequest request){
            this.request = request;
        }
    }
}
