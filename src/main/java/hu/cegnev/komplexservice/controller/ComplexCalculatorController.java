package hu.cegnev.komplexservice.controller;

import hu.cegnev.komplexservice.controller.dto.ComplexCalculatorDto;
import hu.cegnev.komplexservice.controller.dto.ComplexNumberDto;
import hu.cegnev.komplexservice.service.ComplexCalculatorService;
import hu.cegnev.komplexservice.service.ComplexNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complex-number")
public class ComplexCalculatorController {
    private final ComplexCalculatorService complexCalculatorService;


    @GetMapping("/calculator")
    ComplexNumberDto addition(@Valid @RequestBody ComplexCalculatorDto complexCalculatorDto) {
        ComplexNumber operand1 = ComplexNumber.builder()
                .imag(complexCalculatorDto.getOperand1().getImag())
                .real(complexCalculatorDto.getOperand1().getReal())
                .build();

        ComplexNumber operand2 = ComplexNumber.builder()
                .imag(complexCalculatorDto.getOperand2().getImag())
                .real(complexCalculatorDto.getOperand2().getReal())
                .build();

        ComplexNumber result = null;
        switch (complexCalculatorDto.getOperator()) {
            case "+":
                result = complexCalculatorService.addition(operand1, operand2);
                break;
            case "-":
                result = complexCalculatorService.subtraction(operand1, operand2);
                break;
            case "*":
                result = complexCalculatorService.multiplication(operand1, operand2);
                break;
            case "/":
                result = complexCalculatorService.division(operand1, operand2);
                break;
            default:
                throw new ResponseStatusException(
                        HttpStatus.NOT_ACCEPTABLE,
                        "Not supported operation"
                );
        }

        return ComplexNumberDto.builder()
                .imag(result.getImag())
                .real(result.getReal())
                .build();
    }
}
