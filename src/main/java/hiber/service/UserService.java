package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> getUserByModelAndSeries(String model, int series);
    void deleteUser(int id);
    void deleteCar(int id);
}
