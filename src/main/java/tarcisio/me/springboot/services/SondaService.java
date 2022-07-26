package tarcisio.me.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import tarcisio.me.springboot.controllers.dto.ComandoDTO;
import tarcisio.me.springboot.model.Sonda;
import tarcisio.me.springboot.repository.SondaRepository;

@Service
public class SondaService {
    private String posicao = "";
    private int x = 0;
    private int y = 0;
    @Autowired
    private SondaRepository sondaRepository;
    public Sonda tripSonda(Long id, ComandoDTO comando) {

        Optional<Sonda> sondaOptinal = sondaRepository.findById(id);

        // Criar uma lista
        List<String> comandos = Arrays.asList(comando.getComando().split(""));

        Sonda sonda = new Sonda();
        Boolean seguir = false;

        // Pegar dados
        if(sondaOptinal.isPresent()) {
            posicao = sondaOptinal.get().getPosicao();
            sonda = sondaOptinal.get();
            x = sonda.getX();
            y = sonda.getY();
            seguir = true;
        }
        System.out.println("posicao" + posicao);
        System.out.println("sonda" + sonda);
        System.out.println("x" + x);
        System.out.println("y" + y);
        System.out.println("seguir" + seguir);

        if(seguir) {
            comandos.forEach(c -> {
                System.out.println("girar");
                System.out.println("C CCCCC " + c);
            // Girar
                if(c == "L") {
                    if(this.posicao == "N") {
                        this.posicao = "W";
                    } else if (posicao == "S") {
                        this.posicao = "E";
                    } else if (this.posicao == "W") {
                        this.posicao = "S";
                    } else if (this.posicao == "E") {
                        this.posicao = "N";
                    } else {
                        if(this.posicao == "N") {
                            this.posicao = "E";
                        } else if (this.posicao == "S") {
                            this.posicao = "W";
                        } else if (this.posicao == "W") {
                            this.posicao = "N";
                        } else if (this.posicao == "E") {
                            this.posicao = "S";
                        }
                    }
                }

                // Walk
                if(this.posicao == "N") {
                    this.y+=1;
                } else if(this.posicao == "S") {
                    this.y-=1;
                } else if(this.posicao == "E") {
                    this.x+=1;
                } else if(this.posicao == "W") {
                    this.x-=1;
                }
                System.out.println("posi " + posicao);
                System.out.println("yyyy " + y);
                System.out.println("xxxx " + x);

            });
        }

        // Nivel de memoria
        sonda.setPosicao(posicao);
        sonda.setX(x);
        sonda.setY(y);

        System.out.println("111" + posicao);
        System.out.println("111" + x);
        System.out.println("111" + y);

        return sonda;

    }



}
