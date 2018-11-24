package com.piuna.CartaoVacinaOnline.resource;

import com.piuna.CartaoVacinaOnline.domain.Clinica;
import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.domain.Vacina;
import com.piuna.CartaoVacinaOnline.service.ClinicaService;
import com.piuna.CartaoVacinaOnline.service.UsuarioService;
import com.piuna.CartaoVacinaOnline.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ClinicaResource {

    private final ClinicaService clinicaService;

    public ClinicaResource(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    /**
     * Repare que VacinaRepository não possui método nenhum, mas chamamos aqui o método findAll().
     * O método vem da SuperClasse JpaRepository.
     * @return uma lista de todas as vacinas
     */
    @GetMapping("/clinicas")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public List<Clinica> getAll(){
        return clinicaService.getAll();
    }

    @PutMapping("/clinicas")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Clinica> updateClinica(@Valid @RequestBody Clinica clinica)
            throws Exception {
        if (clinica.getId() == null) {
            return createClinica(clinica);
        }
        Clinica result = clinicaService.save(clinica);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("Usuario", clinica.getId().toString()))
                .body(result);
    }

    @PostMapping("/clinicas")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Clinica> createClinica(@Valid @RequestBody Clinica clinica)
            throws Exception {
        if (clinica.getId() != null) {
            throw new Exception("Já existe vacina com o id informado!");
        }
        Clinica result = clinicaService.save(clinica);
        return ResponseEntity.created(new URI("/api/cargos/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("Clínica", result.getId().toString()))
                .body(result);
    }

    @DeleteMapping("/clinicas/{id}")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Clinica> deleteClinica(@PathVariable("id") Long id) {
        this.clinicaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("Clínica", id.toString())).build();
    }

    @GetMapping("clinicas/{id}")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Clinica> findOne(@PathVariable("id") Long id) {
        Clinica result = clinicaService.recuperaPeloId(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> clinicaExceptionHandler(Exception e) {
        return ResponseEntity.badRequest()
                .headers(HeaderUtil.createFailureAlert("Clínica", e.getMessage()))
                .body(null);
    }
}
