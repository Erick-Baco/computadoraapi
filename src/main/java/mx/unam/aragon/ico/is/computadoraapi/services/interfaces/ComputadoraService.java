package mx.unam.aragon.ico.is.computadoraapi.services.interfaces;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computer;

import java.util.Optional;

public interface ComputadoraService {
    public abstract Computer crear(Computer computadora);
    public abstract Iterable<Computer> listarTodas();
    public abstract Optional<Computer> buscarPorId(int id);
    public abstract Computer actualizar(int id, Computer computadora);
    public abstract Computer eliminar(int id);
}
