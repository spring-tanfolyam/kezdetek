package hu.cegnev.komplexservice.service;


import hu.cegnev.komplexservice.ComplexNumberAlreadyExistsException;

import java.util.Collection;

public interface ComplexNumberService {
    void record(ComplexNumber complexNumber) throws ComplexNumberAlreadyExistsException;
    Collection<ComplexNumber> getAll();
}
