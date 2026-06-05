package Day2;

import Day2.config.Con;
import Day2.manager.Connect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Con.class);

        Connect manager =
                context.getBean(Connect.class);

        manager.executeQuery("SELECT * FROM USERS");

        context.close();
    }
}