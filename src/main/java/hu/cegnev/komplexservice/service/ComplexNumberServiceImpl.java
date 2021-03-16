package hu.cegnev.komplexservice.service;

import hu.cegnev.komplexservice.ComplexNumberAlreadyExistsException;
import hu.cegnev.komplexservice.dao.ComplexNumberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ComplexNumberServiceImpl implements ComplexNumberService {

    private final ComplexNumberDao complexNumberDao;

    @Override
    public void record(ComplexNumber complexNumber) throws ComplexNumberAlreadyExistsException {

        Collection<ComplexNumber> all = getAll();
        for (ComplexNumber number: all) {
            if (number.equals(complexNumber)) {
                throw new ComplexNumberAlreadyExistsException();
            }
        }
        complexNumberDao.save(
                hu.cegnev.komplexservice.dao.ComplexNumber.builder()
                        .imag(complexNumber.getImag())
                        .real(complexNumber.getReal())
                        .build()
        );
    }

    @Override
    public Collection<ComplexNumber> getAll() {
        return complexNumberDao.readAll().stream().map(
                daoComplexNumber -> ComplexNumber.builder()
                        .real(daoComplexNumber.getReal())
                        .imag(daoComplexNumber.getImag())
                        .build()
        ).collect(Collectors.toList());
    }
}
