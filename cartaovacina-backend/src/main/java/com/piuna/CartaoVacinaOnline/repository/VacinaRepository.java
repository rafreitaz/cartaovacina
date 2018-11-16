package com.piuna.CartaoVacinaOnline.repository;

import com.piuna.CartaoVacinaOnline.domain.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Os repositories são interfaces que permitem o acesso ao banco.
 */

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface VacinaRepository extends JpaRepository<Vacina, Long> {

    @Query("SELECT v FROM Vacina v WHERE v.id = :id")
    Vacina recuperaPeloId(@Param("id") Long id);

}
