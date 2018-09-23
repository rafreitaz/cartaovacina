package com.piuna.CartaoVacinaOnline.resource;

/**
 * Resources são classes que recebem a chamada do frontEnd e executam algum metodo.
 */

import com.piuna.CartaoVacinaOnline.domain.Vacina;
import com.piuna.CartaoVacinaOnline.repository.VacinaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VacinaResource {

    private final VacinaRepository vacinaRepository;

    public VacinaResource(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    /**
     * Repare que VacinaRepository não possui método nenhum, mas chamamos aqui o método findAll().
     * O método vem da SuperClasse JpaRepository.
     * @return uma lista de todas as vacinas
     */
    @GetMapping("/vacinas") //Aqui definimos como o frontEnd acessa o método. Chamando a url /vacinas o backEnd chama o método aqui.
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Vacina> getAll(){
        return vacinaRepository.findAll();
    }

}
