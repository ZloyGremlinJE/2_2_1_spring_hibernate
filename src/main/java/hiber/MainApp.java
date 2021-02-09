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
        User u1 = userService.getUser(1L);
        User u2 = userService.getUser(2L);
        System.out.println(u1);
        System.out.println(u2);

        Car c1 = userService.getCar(1L);
        Car c2 =userService.getCar(2L);
        User u3 = userService.getUser(4L);
//        u3.addCar(c1);
//        u3.addCar(c2);
        u3.getCars().clear();
        userService.add(u3);
        System.out.println(u3);



//        userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("Лада", 2112)));
//        userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("Волга", 21)));
//        userService.add(new User("User7", "Lastname7", "user7@mail.ru", new Car("BMW", 525)));
//        userService.add(new User("User8", "Lastname8", "user8@mail.ru", new Car("Porshe", 916)));
//
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("Car = " + user.getCar().getModel() + " Series= " + user.getCar().getSeries());
//            System.out.println();
//        }
//
//        users = userService.getUserByCar("Волга", 21);
//        for (User user : users){
//            System.out.println(user);
//        }
        context.close();
    }
}
