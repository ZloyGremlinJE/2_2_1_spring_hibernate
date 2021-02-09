package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void addCar(Car car);
    List<User> listUsers();
    List<User> getUserByCar(String model, int series);
    public User getUser(Long id);
    public Car getCar(Long id);

}
