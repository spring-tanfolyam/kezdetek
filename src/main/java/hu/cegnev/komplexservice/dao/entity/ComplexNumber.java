package hu.cegnev.komplexservice.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class ComplexNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column()
    private double realPart;
    @Column()
    private double imagPart;
}
