package mx.unam.aragon.ico.is.computadoraapi;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computer;
import mx.unam.aragon.ico.is.computadoraapi.respositories.ComputerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputadoraapiApplicationTests {
    @Autowired
    private ComputerRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void insertComputer() {
        Computer computer = new Computer(0,"Apple", "MacBook Air",null, 5000.00f);
        repository.save(computer);
    }

    @Test
    void findOne() {
        int id = 3;
        Computer tmp = repository.findById(id);
        System.out.println(tmp.toString());
    }

    @Test
    void deleteComputer() {
        int id = 1;
        repository.deleteById(id);
    }

    @Test
    void updateComputer() {
        int id = 2;
        Computer tmp = repository.findById(id);
        tmp.setModel("Patito 300");
        repository.save(tmp);

    }

}
