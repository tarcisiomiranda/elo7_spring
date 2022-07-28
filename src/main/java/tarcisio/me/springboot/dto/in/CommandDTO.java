package tarcisio.me.springboot.dto.in;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommandDTO {
    @ApiModelProperty(value = "Comando a ser enviado para a sonda", example = "LMLMLMLMM")
    private String command;
}
