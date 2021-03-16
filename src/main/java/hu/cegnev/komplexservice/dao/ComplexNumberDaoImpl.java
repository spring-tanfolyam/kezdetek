package hu.cegnev.komplexservice.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ComplexNumberDaoImpl implements ComplexNumberDao {

    private final List<ComplexNumber> complexNumberList = new ArrayList<>();

    @Override
    public Collection<ComplexNumber> readAll() {
        return complexNumberList;
    }

    @Override
    public void save(ComplexNumber complexNumber) {
        complexNumberList.add(complexNumber);
    }
}
