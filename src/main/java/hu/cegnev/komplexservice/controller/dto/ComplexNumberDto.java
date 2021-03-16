package hu.cegnev.komplexservice.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComplexNumberDto {

    private double real;

    private double imaginary;
}
