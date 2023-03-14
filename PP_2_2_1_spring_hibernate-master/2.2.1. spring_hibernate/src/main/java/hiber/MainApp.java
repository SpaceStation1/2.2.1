package hiber;

import hiber.config.AppConfig;
//import hiber.model.Car;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

//      userService.delete();

      Car car1 = new Car(1, "1model");
      Car car2 = new Car(2, "2model");
      Car car3 = new Car(3, "3model");
      Car car4 = new Car(4, "4model");
      Car car5 = new Car(5, "5model");
      Car car6 = new Car(6, "6model");
      Car car7 = new Car(7, "7model");
      Car car8 = new Car(8, "8model");
      Car car9 = new Car(9, "9model");
      Car car10 = new Car(10, "10model");

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);
      carService.add(car5);
      carService.add(car6);
      carService.add(car7);
      carService.add(car8);
      carService.add(car9);
      carService.add(car10);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru", car5));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru", car6));
      userService.add(new User("User7", "Lastname7", "user7@mail.ru", car7));
      userService.add(new User("User8", "Lastname8", "user8@mail.ru", car8));
      userService.add(new User("User9", "Lastname9", "user9@mail.ru", car9));
      userService.add(new User("User10", "Lastname10", "user10@mail.ru", car10));

      User userById = userService.getUserById(10L);
      System.out.println(userById.toString());


      User userByModelAndSeries = userService.getUserByModelAndSeries(10, "10model");
      System.out.println(userByModelAndSeries.toString());


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car.id = "+user.getCar().toString());
         System.out.println();
      }

      context.close();
   }
}
