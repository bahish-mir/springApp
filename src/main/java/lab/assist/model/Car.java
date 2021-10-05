package lab.assist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String color;

    @Column(name = "person_id")
    private Long personId;
}
