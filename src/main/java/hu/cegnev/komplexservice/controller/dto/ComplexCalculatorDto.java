package hu.cegnev.komplexservice.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ComplexCalculatorDto {
    @NotNull
    private ComplexNumberRecordDto operand1;
    @NotNull
    private ComplexNumberRecordDto operand2;
    @NotBlank
    @Size(min = 1, max = 1)
    private String operator;
}
