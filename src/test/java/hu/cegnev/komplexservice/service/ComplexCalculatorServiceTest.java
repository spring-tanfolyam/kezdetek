package hu.cegnev.komplexservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexCalculatorServiceTest {

    @Test
    void addition() {
        // GIVEN
        ComplexCalculatorService complexCalculatorService = new ComplexCalculatorServiceImpl();
        ComplexNumber operand1 = ComplexNumber.builder().imag(2).real(4).build();
        ComplexNumber operand2 = ComplexNumber.builder().imag(3).real(3).build();;

        // WHEN
        ComplexNumber result = complexCalculatorService.addition(operand1, operand2);

        // THEN
        assertEquals(5, result.getImag());
        assertEquals(7, result.getReal());
    }

    @Test
    void subtraction() {
        // GIVEN
        ComplexCalculatorService complexCalculatorService = new ComplexCalculatorServiceImpl();
        ComplexNumber operand1 = ComplexNumber.builder().imag(5).real(4).build();
        ComplexNumber operand2 = ComplexNumber.builder().imag(3).real(3).build();;

        // WHEN
        ComplexNumber result = complexCalculatorService.subtraction(operand1, operand2);

        // THEN
        assertEquals(2, result.getImag());
        assertEquals(1, result.getReal());
    }

    @Test
    void multiplication() {
        // GIVEN
        ComplexCalculatorService complexCalculatorService = new ComplexCalculatorServiceImpl();
        ComplexNumber operand1 = ComplexNumber.builder().real(1).imag(2).build();
        ComplexNumber operand2 = ComplexNumber.builder().real(3).imag(4).build();;

        // WHEN
        ComplexNumber result = complexCalculatorService.multiplication(operand1, operand2);

        // THEN
        assertEquals(-5, result.getReal());
        assertEquals(10, result.getImag());
    }

    @Test
    void division() {
        fail();
    }
}