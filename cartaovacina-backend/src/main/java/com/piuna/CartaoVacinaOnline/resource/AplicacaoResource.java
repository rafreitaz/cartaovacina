package com.piuna.CartaoVacinaOnline.resource;

import com.piuna.CartaoVacinaOnline.domain.AplicacaoVacina;
import com.piuna.CartaoVacinaOnline.dto.AplicacaoVacinaDTO;
import com.piuna.CartaoVacinaOnline.service.AplicacaoService;
import com.piuna.CartaoVacinaOnline.service.UsuarioService;
import com.piuna.CartaoVacinaOnline.util.HeaderUtil;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AplicacaoResource {

    private final AplicacaoService aplicacaoService;

    private final UsuarioService usuarioService;

    public AplicacaoResource(AplicacaoService aplicacaoService, UsuarioService usuarioService) {
        this.aplicacaoService = aplicacaoService;
        this.usuarioService = usuarioService;
    }

    /**
     * Repare que VacinaRepository não possui método nenhum, mas chamamos aqui o método findAll().
     * O método vem da SuperClasse JpaRepository.
     * @return uma lista de todas as vacinas
     */
    @GetMapping("/aplicacao/{idUsuario}")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public List<AplicacaoVacinaDTO> getAll(@PathVariable("idUsuario") Long idUsuario){
        return aplicacaoService.getAll(idUsuario);
    }

    @PutMapping("/aplicacao")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<AplicacaoVacina> updateAplicacao(@Valid @RequestBody AplicacaoVacina aplicacao)
            throws Exception {
        if (aplicacao.getId() == null) {
            return createAplicacao(aplicacao);
        }
        AplicacaoVacina result = aplicacaoService.save(aplicacao);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("Aplicacao", aplicacao.getId().toString()))
                .body(result);
    }

    @PostMapping("/aplicacao")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<AplicacaoVacina> createAplicacao(@Valid @RequestBody AplicacaoVacina aplicacao)
            throws Exception {
        if (aplicacao.getId() != null) {
            throw new Exception("Já existe aplicação com o id informado!");
        }
        AplicacaoVacina result = aplicacaoService.save(aplicacao);
        return ResponseEntity.created(new URI("/aplicacao/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("Aplicação", result.getId().toString()))
                .body(result);
    }

    @DeleteMapping("/aplicacao/{id}")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public ResponseEntity<AplicacaoVacina> deleteAplicacao(@PathVariable("id") Long id) {
        this.aplicacaoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("Aplicação", id.toString())).build();
    }

    @GetMapping(value = "/aplicacao/exportacao/{idUsuario}", produces = MediaType.APPLICATION_PDF_VALUE)
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"X-cv-error"})
    public byte[] report(HttpServletResponse response, @PathVariable("idUsuario") Long idUsuario) throws JRException {
        return aplicacaoService.generatePDFReport(idUsuario);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> aplicacaoExceptionHandler(Exception e) {
        return ResponseEntity.badRequest()
                .headers(HeaderUtil.createFailureAlert("Clínica", e.getMessage()))
                .body(null);
    }
}
