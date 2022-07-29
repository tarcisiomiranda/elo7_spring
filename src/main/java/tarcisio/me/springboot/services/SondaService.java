package tarcisio.me.springboot.services;

import tarcisio.me.springboot.repository.SondaRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tarcisio.me.springboot.dto.in.CommandDTO;
import tarcisio.me.springboot.model.Sonda;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

@Service
public class SondaService {
    @Autowired private SondaRepository sondaRepository;
    
    public Sonda findSonda(Long id) {
        Optional<Sonda> obj = sondaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id,
        "Sonda not found "+ id));
    }

    public Sonda runTrip(Long id, CommandDTO commandDTO) {
        List<String> commands = Arrays.asList(commandDTO.getCommand().split(""));
        Sonda sonda = findSonda(id);

        commands.forEach(command -> {
            if(command.equals("M")){
                forward(sonda);
            } else {
                turn(sonda, command);
            }
        });
        return sonda;
    };

    public void turn(Sonda sonda, String command) {
        String newPosition = "";
        if(command.equals("R")){
            if(sonda.getPosicao().equals("N")) newPosition = "E";
            if(sonda.getPosicao().equals("E")) newPosition = "S";
            if(sonda.getPosicao().equals("S")) newPosition = "W";
            if(sonda.getPosicao().equals("W")) newPosition = "N";
        } else {
            if(sonda.getPosicao().equals("N")) newPosition = "W";
            if(sonda.getPosicao().equals("W")) newPosition = "S";
            if(sonda.getPosicao().equals("S")) newPosition = "E";
            if(sonda.getPosicao().equals("E")) newPosition = "N";
        }
        sonda.setPosicao(newPosition);
    }

    private void forward(Sonda sonda) {
        if(sonda.getPosicao().equals("N")) sonda.setY(sonda.getY() + 1);
        if(sonda.getPosicao().equals("E")) sonda.setX(sonda.getX() + 1);
        if(sonda.getPosicao().equals("S")) sonda.setY(sonda.getY() - 1);
        if(sonda.getPosicao().equals("W")) sonda.setX(sonda.getX() - 1);
    }
}
