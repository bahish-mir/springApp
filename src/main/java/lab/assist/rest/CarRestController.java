package lab.assist.rest;

import lab.assist.model.Car;
import lab.assist.service.CarService;
import lab.assist.specifications.CarSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarRestController {
    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public ResponseEntity<?> getCar(CarSpecification carSpecification) {
        return ResponseEntity.ok(carService.find(carSpecification));
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
