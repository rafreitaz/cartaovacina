package com.piuna.CartaoVacinaOnline.resource;

/**
 * Resources são classes que recebem a chamada do frontEnd e executam algum metodo.
 */

import com.piuna.CartaoVacinaOnline.service.VacinaService;
import com.piuna.CartaoVacinaOnline.util.HeaderUtil;
import com.piuna.CartaoVacinaOnline.domain.Vacina;
import com.piuna.CartaoVacinaOnline.repository.VacinaRepository;
import io.github.jhipster.web.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class VacinaResource {

    private final VacinaService vacinaService;

    public VacinaResource(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    /**
     * Repare que VacinaRepository não possui método nenhum, mas chamamos aqui o método findAll().
     * O método vem da SuperClasse JpaRepository.
     * @return uma lista de todas as vacinas
     */
    @GetMapping("/vacinas") //Aqui definimos como o frontEnd acessa o método. Chamando a url /vacinas o backEnd chama o método aqui.
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Vacina> getAll(){
        return vacinaService.getAll();
    }

    @PutMapping("/vacinas")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Vacina> updateVacina(@Valid @RequestBody Vacina vacina)
            throws Exception {
        if (vacina.getId() == null) {
            return createVacina(vacina);
        }
        Vacina result = vacinaService.save(vacina);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("Vacina", vacina.getId().toString()))
                .body(result);
    }

    @PostMapping("/vacinas")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Vacina> createVacina(@Valid @RequestBody Vacina vacina)
            throws Exception {
        if (vacina.getId() != null) {
            throw new Exception("Já existe vacina com o id informado!");
        }
        Vacina result = vacinaService.save(vacina);
        return ResponseEntity.created(new URI("/api/cargos/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("Vacina", result.getId().toString()))
                .body(result);
    }

    @DeleteMapping("/vacinas/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Vacina> createVacina(@PathVariable("id") Long id) {
        this.vacinaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("Vacina", id.toString())).build();
    }

    @GetMapping("vacinas/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Vacina> findOne(@PathVariable("id") Long id) {
        Vacina result = vacinaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

}
