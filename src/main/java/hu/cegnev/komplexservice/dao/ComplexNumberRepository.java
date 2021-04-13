package hu.cegnev.komplexservice.dao;

import hu.cegnev.komplexservice.dao.entity.ComplexNumber;
import org.springframework.data.repository.CrudRepository;

public interface ComplexNumberRepository extends CrudRepository<ComplexNumber, Long> {
}
