package mx.unam.aragon.ico.is.computadoraapi.services;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computer;
import mx.unam.aragon.ico.is.computadoraapi.respositories.ComputerRepository;
import mx.unam.aragon.ico.is.computadoraapi.services.interfaces.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputadoraServiceImpl implements ComputadoraService {
    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public Computer crear(Computer computadora) {
        return computerRepository.save(computadora);
    }

    @Override
    public Iterable<Computer> listarTodas() {
        return computerRepository.findAll();
    }

    @Override
    public Optional<Computer> buscarPorId(int id) {
        return Optional.ofNullable(computerRepository.findById(id));
    }

    @Override
    public Computer actualizar(int id, Computer computadora) {
        Optional<Computer> newComputer = Optional.ofNullable(computerRepository.findById(id));
        if (newComputer.isPresent()) {
            Computer tmp = newComputer.get();
            tmp.setId(id);
            tmp.setModel(computadora.getModel());
            tmp.setBrand(computadora.getBrand());
            tmp.setPrice(computadora.getPrice());
            tmp.setPhoto(computadora.getPhoto());
            return computerRepository.save(tmp);
        } else {
            return null;
        }

    }

    @Override
    public Computer eliminar(int id) {
        return computerRepository.deleteById(id);
    }
}
