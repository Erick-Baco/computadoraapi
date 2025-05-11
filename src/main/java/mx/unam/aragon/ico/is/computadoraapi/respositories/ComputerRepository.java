package mx.unam.aragon.ico.is.computadoraapi.respositories;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computer;
import org.springframework.data.repository.CrudRepository;

public interface ComputerRepository extends CrudRepository<Computer, Integer> {
    public Computer findById(int id);
    public Computer deleteById(int id);
}
