package com.piuna.CartaoVacinaOnline.resource;

import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.domain.Vacina;
import com.piuna.CartaoVacinaOnline.service.UsuarioService;
import com.piuna.CartaoVacinaOnline.service.VacinaService;
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
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Repare que VacinaRepository não possui método nenhum, mas chamamos aqui o método findAll().
     * O método vem da SuperClasse JpaRepository.
     * @return uma lista de todas as vacinas
     */
    @GetMapping("/usuarios")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }

    @PutMapping("/usuarios")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Usuario> updateUsuario(@Valid @RequestBody Usuario usuario)
            throws Exception {
        if (usuario.getId() == null) {
            return createUsuario(usuario);
        }
        Usuario result = usuarioService.save(usuario);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("Usuario", usuario.getId().toString()))
                .body(result);
    }

    @PostMapping("/usuarios")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario)
            throws Exception {
        if (usuario.getId() != null) {
            throw new Exception("Já existe vacina com o id informado!");
        }
        Usuario result = usuarioService.save(usuario);
        return ResponseEntity.created(new URI("/api/cargos/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("Usuario", result.getId().toString()))
                .body(result);
    }

    @DeleteMapping("/usuarios/{id}")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Long id) {
        this.usuarioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("Usuário", id.toString())).build();
    }

    @GetMapping("usuarios/{id}")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Usuario> findOne(@PathVariable("id") Long id) {
        Usuario result = usuarioService.recuperaPeloId(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

    @GetMapping("usuarios/cpf/{cpf}")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Usuario> recuperaPeloCpf(@PathVariable("cpf") String cpf) {
        Usuario result = usuarioService.findOne(cpf);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

    @GetMapping("usuarios/logar/{login}/{senha}")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<Usuario> logarUsuario(@PathVariable("login") String login, @PathVariable("senha") String senha) {
        Usuario result = usuarioService.recuperaUsuarioLogin(login, senha);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> clinicaExceptionHandler(Exception e) {
        return ResponseEntity.badRequest()
                .headers(HeaderUtil.createFailureAlert("Usuário", e.getMessage()))
                .body(null);
    }

}
