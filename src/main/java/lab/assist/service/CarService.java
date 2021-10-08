package lab.assist.service;

import lab.assist.model.Car;
import lab.assist.specifications.CarSpecification;

import java.util.List;

public interface CarService {

    List<Car> find(CarSpecification carSpecification);

    void updateCar(Car car);

    void createCar(Car car);

    void deleteCarById(Long id);

    Car getCarById(Long id);
}
