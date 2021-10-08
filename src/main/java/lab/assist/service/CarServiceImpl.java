package lab.assist.service;

import lab.assist.model.Car;
import lab.assist.repository.CarRepo;
import lab.assist.specifications.CarSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepo carRepo;

    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public List<Car> find(CarSpecification carSpecification) {
        return carRepo.findAll(carSpecification);
    }

    @Override
    public void updateCar(Car car) {
        carRepo.save(car);
    }

    @Override
    public void createCar(Car car) {
        carRepo.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepo.deleteById(id);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepo.getById(id);
    }
}
