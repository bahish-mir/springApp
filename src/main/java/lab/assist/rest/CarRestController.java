package lab.assist.rest;

import lab.assist.model.Car;
import lab.assist.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {
    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Car car = carService.getCarById(id);

        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCar() {
        List<Car> cars = carService.getAll();

        if (cars.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        Car car = carService.getCarById(id);

        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        carService.deleteCarById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("")
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        carService.createCar(car);

        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@RequestBody Car car) {
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        carService.updateCar(car);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

}
