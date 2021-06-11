import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import java.util.HashMap;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Spark.webSocket("/websocet/echo", EchoWebSocket.class);
        Spark.get("/",(request,response)->{return "Hello";});
        Spark.get("/echo",(request,response)->{HashMap<String,Object> model= new HashMap();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "echoview"));});
        Spark.init();
    }
}
