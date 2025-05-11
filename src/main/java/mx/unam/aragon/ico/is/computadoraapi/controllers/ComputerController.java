package mx.unam.aragon.ico.is.computadoraapi.controllers;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computer;
import mx.unam.aragon.ico.is.computadoraapi.respositories.ComputerRepository;
import mx.unam.aragon.ico.is.computadoraapi.services.interfaces.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/computers")
public class ComputerController {

    @Autowired
    private ComputadoraService computadoraService;

    private static String URI_LOCAL = "http://localhost:8080";

    @GetMapping("/")
    public ResponseEntity<Iterable<Computer>> getComputers() {
        return new ResponseEntity<>(computadoraService.listarTodas(), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Computer> getComputer(@PathVariable int id) {
        return new ResponseEntity<>(computadoraService.buscarPorId(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Computer> createComputer(@RequestBody Computer computer) throws URISyntaxException {
        return ResponseEntity.created(new URI(URI_LOCAL)).body( computadoraService.crear(computer));
    }
}
