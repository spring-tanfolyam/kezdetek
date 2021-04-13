package hu.cegnev.komplexservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ComplexNumberRecordDto {
    @NotNull
    private Double real;
    @NotNull
    private Double imag;
}
