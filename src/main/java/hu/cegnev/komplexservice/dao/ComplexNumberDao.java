package hu.cegnev.komplexservice.dao;

import java.util.Collection;

public interface ComplexNumberDao {
    Collection<ComplexNumber> readAll();
    void save(ComplexNumber complexNumber);
}
