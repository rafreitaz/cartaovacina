package com.piuna.CartaoVacinaOnline.repository;

import com.piuna.CartaoVacinaOnline.domain.Clinica;
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
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {

    @Query("SELECT COUNT(c.id) FROM Clinica c WHERE c.cnpj = :cnpj")
    Long recuperaPeloCnpj(@Param("cnpj") String cnpj);

    @Query("SELECT c FROM Clinica c WHERE c.id = :id")
    Clinica recuperaPeloId(@Param("id") Long id);
}
