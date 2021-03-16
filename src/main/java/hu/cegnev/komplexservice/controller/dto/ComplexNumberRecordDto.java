package hu.cegnev.komplexservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ComplexNumberRecordDto {
    private double real;
    private double imag;
}
