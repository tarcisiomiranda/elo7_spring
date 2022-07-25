package tarcisio.me.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
import javax.persistence.Table;

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

    // @GeneratedValue(strategy =GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private int x;
    private int y;
    private String posicao;

}
