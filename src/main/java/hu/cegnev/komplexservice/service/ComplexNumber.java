package hu.cegnev.komplexservice.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ComplexNumber {
    private double real;
    private double imag;

    @Override
    public String toString() {
        return "ComplexNumber { " +
                real +
                ", " + imag +
                "i }";
    }
}
