package hu.cegnev.komplexservice.service;

public interface ComplexCalculatorService {
    ComplexNumber addition(ComplexNumber a, ComplexNumber b);
    ComplexNumber subtraction(ComplexNumber a, ComplexNumber b);
    ComplexNumber multiplication(ComplexNumber a, ComplexNumber b);
    ComplexNumber division(ComplexNumber a, ComplexNumber b);
}
