package com.piuna.CartaoVacinaOnline.repository;

import com.piuna.CartaoVacinaOnline.domain.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Os repositories são interfaces que permitem o acesso ao banco.
 */

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface VacinaRepository extends JpaRepository<Vacina, Long> {

}
