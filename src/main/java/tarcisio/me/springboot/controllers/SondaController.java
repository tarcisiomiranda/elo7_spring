package tarcisio.me.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import tarcisio.me.springboot.dto.in.CommandDTO;
import tarcisio.me.springboot.model.Sonda;
import tarcisio.me.springboot.repository.SondaRepository;
import tarcisio.me.springboot.services.SondaService;

@RestController
@RequestMapping("/sondas")
public class SondaController {

    private List<Sonda> sondas = new ArrayList<>();

    @Autowired
    private SondaRepository sondaRepository;

    @Autowired
    private SondaService sondaService;

    @GetMapping("/{id}")
    public Sonda sonda(@PathVariable("id") Long id) {
        System.out.println("Sonda ID: " + id);

        Optional<Sonda> sondaFind = this.sondaRepository.findById(id);
        if(sondaFind.isPresent()) {
            return sondaFind.get();
            }
        return null;
    }

    @PostMapping("/trip/{id}")
    public ResponseEntity<Sonda> sendTrip(
    @PathVariable("id")
    @ApiParam(name = "id", value = "ID da Sonda.", example = "1") Long id,
    @RequestBody CommandDTO CommandDTO
    ) { 
        System.out.println("Comando Controller: " + CommandDTO.getCommand());
        return ResponseEntity.ok(sondaService.runTrip(id, CommandDTO));
    }

    @PostMapping("/")
    public Sonda sonda(@RequestBody Sonda sonda) {
        this.sondaRepository.save(sonda);
        sondas.add(sonda);
        return sonda;
    }

    @GetMapping("/list")
    public List<Sonda> list() {
        return this.sondaRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public List<Sonda> listById(@PathVariable("id") Long id) {
        return this.sondaRepository.findAllmoreThan(id);
    }

    @GetMapping("/findByName/{name}")
    public List<Sonda> findByName(@PathVariable("name") String name) {
        return this.sondaRepository.findByNameIgnoreCase(name);
    }

}
