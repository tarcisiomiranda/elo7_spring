package tarcisio.me.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tarcisio.me.springboot.model.Sonda;

public interface SondaRepository extends JpaRepository<Sonda, Long> {

    @Query("SELECT u from Sonda u WHERE u.id = :id")
    public List<Sonda> findAllmoreThan(@Param("id") Long id);

    public List<Sonda> findAllmoreThan(Long id);

    public List<Sonda> findByNameIgnoreCase(String name);

    public List<Sonda> findByPosicaoIgnoreCase(String posicao);

}

// 20:18