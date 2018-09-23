package com.piuna.CartaoVacinaOnline.repository;

import com.piuna.CartaoVacinaOnline.domain.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Os repositories são interfaces que permitem o acesso ao banco.
 */

@RepositoryRestResource
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
}
