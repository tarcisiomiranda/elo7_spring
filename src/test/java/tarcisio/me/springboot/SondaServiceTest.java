package tarcisio.me.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tarcisio.me.springboot.dto.in.CommandDTO;
import tarcisio.me.springboot.model.Sonda;
import tarcisio.me.springboot.repository.SondaRepository;
import tarcisio.me.springboot.services.SondaService;

@ExtendWith(MockitoExtension.class)
class SondaServiceTest {
    @InjectMocks
    private SondaService service;

    @Mock
    private SondaRepository repository;
    private Long id = Long.valueOf(1) ;
    private final String RESPONSETHROW = "No row with the given identifier exists:" +
            " [Sonda not found 1#1]";

    @Test
    void findOk() {
        Sonda expect = findSonda();
        when(repository.findById(id)).thenReturn(Optional.of(expect)) ;
        Sonda response = service.findSonda(id);
        assertEquals(expect.getPosicao(),response.getPosicao() );
        assertEquals(expect.getX(),response.getX() );
        assertEquals(expect.getY(), response.getY());
        assertEquals(expect.getName(), response.getName());
        assertEquals(expect.getId(), response.getId());
    }

    @Test
    void findThrow() {
    when(repository.findById(id)).thenReturn(Optional.empty()) ;
        try{
            service.findSonda(id);
        }catch (Exception e){
            assertEquals(RESPONSETHROW, e.getMessage());
        }
    }

    @Test
    void moveWithSingleCommandWhitSonda1(){
        when(repository.findById(id)).thenReturn(Optional.of(findSonda())) ;
        Sonda response = service.runTrip(id,getCommandDTO("M"));
        assertEquals(3, response.getY());
    }

    @Test
    void moveWithDoubleCommandWhitSonda1(){
        when(repository.findById(id)).thenReturn(Optional.of(findSonda())) ;
        Sonda response = service.runTrip(id,getCommandDTO("ML"));
        assertEquals(1, response.getX());
        assertEquals(3, response.getY());
        assertEquals("W", response.getPosicao());
    }

    @Test
    void command1Sonda1(){
        when(repository.findById(id)).thenReturn(Optional.of(findSonda())) ;
        Sonda response = service.runTrip(id,getCommandDTO("LMLMLMLMM"));
        assertEquals(1, response.getX());
        assertEquals(3, response.getY());
        assertEquals("N", response.getPosicao());
    }

    public CommandDTO getCommandDTO(String command){
        CommandDTO commandDTO = new CommandDTO();
        commandDTO.setCommand(command);
        return  commandDTO;
    }

    private Sonda findSonda() {
        Sonda sonda = new Sonda();
        sonda.setId(id);
        sonda.setPosicao("N");
        sonda.setX(1);
        sonda.setY(2);
        sonda.setName("sonda1");
        return  sonda;
    }

}
