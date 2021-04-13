package hu.cegnev.komplexservice.service;

import hu.cegnev.komplexservice.ComplexNumberAlreadyExistsException;
import hu.cegnev.komplexservice.dao.ComplexNumberDao;
import hu.cegnev.komplexservice.dao.ComplexNumberDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComplexNumberServiceImplTest {


    @Test
    void record_success() throws ComplexNumberAlreadyExistsException {
        // GIVEN
        ComplexNumberDao complexNumberDao = mock(ComplexNumberDao.class);
        hu.cegnev.komplexservice.dao.ComplexNumber demoComplexNumber = getDemoComplexNumber();
        when(complexNumberDao.readAll()).thenReturn(getDemoArray(demoComplexNumber));

        ComplexNumberService complexNumberService = new ComplexNumberServiceImpl(complexNumberDao);

        // WHEN
        complexNumberService.record(
                ComplexNumber.builder()
                        .real(2)
                        .imag(5)
                        .build()
        );

        // THEN
        verify(complexNumberDao, times(1)).readAll();
        verify(complexNumberDao, times(1)).save(any());
    }

    @Test()
    void record_noSave() throws ComplexNumberAlreadyExistsException {
        // GIVEN
        ComplexNumberDao complexNumberDao = mock(ComplexNumberDao.class);
        hu.cegnev.komplexservice.dao.ComplexNumber demoComplexNumber = getDemoComplexNumber();
        when(complexNumberDao.readAll()).thenReturn(getDemoArray(demoComplexNumber));

        ComplexNumberService complexNumberService = new ComplexNumberServiceImpl(complexNumberDao);

        // WHEN
        Assertions.assertThrows(ComplexNumberAlreadyExistsException.class, () -> {
            complexNumberService.record(
                    ComplexNumber.builder()
                            .real(demoComplexNumber.getReal())
                            .imag(demoComplexNumber.getImag())
                            .build()
            );
        });

        // THEN
        verify(complexNumberDao, times(1)).readAll();
        verify(complexNumberDao, times(0)).save(any());
    }

    @Test
    void getAll_WithEmptyList() {
        // GIVEN
        ComplexNumberDao complexNumberDao = mock(ComplexNumberDao.class);
        when(complexNumberDao.readAll()).thenReturn(new ArrayList<>());
        ComplexNumberService complexNumberService = new ComplexNumberServiceImpl(complexNumberDao);

        // WHEN
        Collection<ComplexNumber> all = complexNumberService.getAll();

        // THEN
        assertTrue(all.isEmpty());
        verify(complexNumberDao, times(1)).readAll();
    }

    @Test
    void getAll_WithAnyList() {
        // GIVEN
        ComplexNumberDao complexNumberDao = mock(ComplexNumberDao.class);
        hu.cegnev.komplexservice.dao.ComplexNumber demoComplexNumber = getDemoComplexNumber();
        when(complexNumberDao.readAll()).thenReturn(getDemoArray(demoComplexNumber));
        ComplexNumberService complexNumberService = new ComplexNumberServiceImpl(complexNumberDao);

        // WHEN
        Collection<ComplexNumber> all = complexNumberService.getAll();

        // THEN
        assertEquals(1, all.size());
        ComplexNumber complexNumber1 = all.iterator().next();
        assertEquals(demoComplexNumber.getReal(), complexNumber1.getReal());
        assertEquals(demoComplexNumber.getImag(), complexNumber1.getImag());
        verify(complexNumberDao, times(1)).readAll();
    }
    private hu.cegnev.komplexservice.dao.ComplexNumber getDemoComplexNumber() {
        return hu.cegnev.komplexservice.dao.ComplexNumber.builder()
                .real(123)
                .imag(432)
                .build();
    }

    private ArrayList<hu.cegnev.komplexservice.dao.ComplexNumber>
    getDemoArray(hu.cegnev.komplexservice.dao.ComplexNumber item ) {

        ArrayList<hu.cegnev.komplexservice.dao.ComplexNumber> arrayList = new ArrayList<>();
        arrayList.add(item);

        return arrayList;
    }
}