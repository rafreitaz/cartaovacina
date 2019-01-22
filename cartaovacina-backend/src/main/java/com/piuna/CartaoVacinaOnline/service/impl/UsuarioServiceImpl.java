package com.piuna.CartaoVacinaOnline.service.impl;

import com.piuna.CartaoVacinaOnline.domain.Acesso;
import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.repository.AcessoRepository;
import com.piuna.CartaoVacinaOnline.repository.UsuarioRepository;
import com.piuna.CartaoVacinaOnline.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final AcessoRepository acessoRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, AcessoRepository acessoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.acessoRepository = acessoRepository;
    }

    @Override
    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario findOne(String cpf) {
        return this.usuarioRepository.recuperaPeloCpf(cpf);
    }

    @Override
    public Usuario recuperaPeloId(Long id) {
        return this.usuarioRepository.recuperaPeloId(id);
    }

    @Override
    public Usuario recuperaUsuarioLogin(String login, String senha) {
        return this.usuarioRepository.recuperaUsuarioLogin(login, senha);
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        validaCPF(usuario.getCpf());
        validaLogin(usuario.getAcesso().getLogin());
        Acesso acesso = preProcessAcesso(usuario);
        usuario.setAcesso(acesso);
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    @Override
    public String getNomePeloId(Long id) {
        return this.usuarioRepository.getNomePeloId(id);
    }

    private Acesso preProcessAcesso(Usuario usuario) {
        Acesso acesso = new Acesso();
        acesso.setLogin(usuario.getAcesso().getLogin());
        acesso.setSenha(usuario.getAcesso().getSenha());
        acesso.setTipoAcesso("U");
        return this.acessoRepository.save(acesso);
    }

    private void validaLogin(String login) throws Exception {
        if (this.acessoRepository.recuperaCountLogin(login) != 0) {
            throw new Exception("Login informado já existe. Favor escolher outro.");
        }
    }

    private void validaCPF(String cpf) throws Exception {
        if (this.usuarioRepository.recuperaPeloCpf(cpf) != null) {
            throw new Exception("Já existe usuário cadastrado com o CPF informado!");
        }
    }
}
