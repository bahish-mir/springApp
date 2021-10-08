package lab.assist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @Transient
    private List<Car> cars;
}
