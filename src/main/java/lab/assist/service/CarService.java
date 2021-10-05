package lab.assist.service;

import lab.assist.model.Car;
import lab.assist.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public List<Car> getAll() {
        return carRepo.findAll();
    }

    public Car getCarById(Long id) {
        return carRepo.getById(id);
    }

    public void updateCar(Car car) {
        carRepo.save(car);
    }

    public void createCar(Car car) {
        carRepo.save(car);
    }

    public void deleteCarById(Long id) {
        carRepo.deleteById(id);
    }
}
