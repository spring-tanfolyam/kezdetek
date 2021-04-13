package hu.cegnev.komplexservice.service;

import org.springframework.stereotype.Service;

@Service
public class ComplexCalculatorServiceImpl implements ComplexCalculatorService {
    @Override
    public ComplexNumber addition(ComplexNumber a, ComplexNumber b) {
        return ComplexNumber.builder()
                .real(a.getReal() + b.getReal())
                .imag(a.getImag() + b.getImag())
                .build();
    }

    @Override
    public ComplexNumber subtraction(ComplexNumber a, ComplexNumber b) {
        return ComplexNumber.builder()
                .real(a.getReal() - b.getReal())
                .imag(a.getImag() - b.getImag())
                .build();
    }

    @Override
    public ComplexNumber multiplication(ComplexNumber a, ComplexNumber b) {
        return ComplexNumber.builder()
                .real(a.getReal() * b.getReal() - a.getImag() * b.getImag())
                .imag(a.getReal() * b.getImag() + a.getImag() * b.getReal())
                .build();
    }

    @Override
    public ComplexNumber division(ComplexNumber a, ComplexNumber b) {
        return ComplexNumber.builder().build();
    }
}
