package Server;

import Menu.Beverage;
import Menu.BeverageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CafeHandler implements HttpHandler {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final Charset CHAR_SET = StandardCharsets.UTF_8;
    private static final int STATUS_OK = 200;
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        ObjectMapper mapper = new ObjectMapper();
        URI requestURI;
        String responseBody;
        byte[] rawResponseBody;
        String requestMethod = exchange.getRequestMethod().toUpperCase();
        List<Beverage> menus;
        switch(requestMethod){
            case GET-> {
                requestURI = exchange.getRequestURI();
                String requestParameters = requestURI.getRawQuery();
                System.out.println("request received : " + requestURI);
                menus = BeverageRepository.getInstance().getBeverageList();
                responseBody = menus.toString();
                responseBody = mapper.writeValueAsString(menus);
                headers.set(HEADER_CONTENT_TYPE, String.format("application/json; charset=%s", CHAR_SET));
                rawResponseBody = responseBody.getBytes(CHAR_SET);
                exchange.sendResponseHeaders(STATUS_OK, rawResponseBody.length);
                exchange.getResponseBody().write(rawResponseBody);

                System.out.println("ASdf");
            }
            case POST->{

            }
            case DELETE->{

            }
        }
    }
}
