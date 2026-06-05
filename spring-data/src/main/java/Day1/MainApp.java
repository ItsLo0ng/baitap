package Day1;

import Day1.config.AppConfig;
import Day1.manager.NotificationManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        NotificationManager manager =
                context.getBean(NotificationManager.class);

        manager.notifyUser("Hello Spring!");
    }
}