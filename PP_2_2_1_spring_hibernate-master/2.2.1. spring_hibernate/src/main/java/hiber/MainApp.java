package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("John", "Doe", "johndoe@example.com");
      Car car1 = new Car("BMW", 5);
      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User("Jane", "Doe", "janedoe@example.com");
      Car car2 = new Car("Audi", 4);
      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User("Alice", "Smith", "alicesmith@example.com");
      Car car3 = new Car("Mercedes", 7);
      user3.setCar(car3);
      userService.add(user3);

      User user4 = new User("Bob", "Johnson", "bobjohnson@example.com");
      Car car4 = new Car("BMW", 5);
      user4.setCar(car4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      List<User> usersWithSpecifiedCar = userService.getUserByCarModelAndSeries("BMW", 5);
      System.out.println("Users with specified car:");
      for (User userWithCar : usersWithSpecifiedCar) {
         System.out.println(userWithCar);
      }

      context.close();
   }
}