package tarcisio.me.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sondas")
public class Sonda {

    @Id
    @ApiModelProperty(value = "id = Número da sonda", example = "1")
    private Long id;
    @ApiModelProperty(value = "name = Nome da sonda", example = "sonda1")
    private String name;
    @ApiModelProperty(value = "eixo X que vai de 1 a 5", example = "3")
    private int x;
    @ApiModelProperty(value = "eixo Y que vai de 1 a 5", example = "1")
    private int y;
    @ApiModelProperty(value = "Posição da sonda como: N S E W", example = "W")
    private String posicao;

}
