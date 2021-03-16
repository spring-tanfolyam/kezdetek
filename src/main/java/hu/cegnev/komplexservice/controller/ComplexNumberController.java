package hu.cegnev.komplexservice.controller;

import hu.cegnev.komplexservice.ComplexNumberAlreadyExistsException;
import hu.cegnev.komplexservice.controller.dto.ComplexNumberDto;
import hu.cegnev.komplexservice.controller.dto.ComplexNumberRecordDto;
import hu.cegnev.komplexservice.service.ComplexNumber;
import hu.cegnev.komplexservice.service.ComplexNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RequestMapping("/complex-number")
@RestController
@RequiredArgsConstructor
public class ComplexNumberController {
    private final ComplexNumberService complexNumberService;

    @PostMapping("/record")
    public void record(@RequestBody ComplexNumberRecordDto dto) {
        try {
            complexNumberService.record(
                    ComplexNumber.builder()
                            .imag(dto.getImag())
                            .real(dto.getReal())
                            .build()
            );
        } catch (ComplexNumberAlreadyExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ComplexNumberDto> query() {
        return complexNumberService.getAll().stream().map(model ->
                ComplexNumberDto.builder()
                        .real(model.getReal())
                        .imaginary(model.getImag())
                        .build()
        ).collect(Collectors.toList());
    }
}
