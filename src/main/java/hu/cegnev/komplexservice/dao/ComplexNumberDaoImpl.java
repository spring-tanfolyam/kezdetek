package hu.cegnev.komplexservice.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Slf4j
@RequiredArgsConstructor
public class ComplexNumberDaoImpl implements ComplexNumberDao {
    private final ComplexNumberRepository complexNumberRepository;

    @Override
    public Collection<ComplexNumber> readAll() {
        return StreamSupport.stream(complexNumberRepository.findAll().spliterator(), false)
                .map(entity -> ComplexNumber.builder()
                        .real(entity.getRealPart())
                        .imag(entity.getImagPart())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void save(ComplexNumber complexNumber) {

        hu.cegnev.komplexservice.dao.entity.ComplexNumber entity =
                new hu.cegnev.komplexservice.dao.entity.ComplexNumber();
        entity.setImagPart(complexNumber.getImag());
        entity.setRealPart(complexNumber.getReal());
        complexNumberRepository.save(entity);
    }
}
