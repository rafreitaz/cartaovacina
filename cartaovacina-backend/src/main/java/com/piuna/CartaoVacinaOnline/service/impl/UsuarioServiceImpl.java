package com.piuna.CartaoVacinaOnline.service.impl;

import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.domain.Vacina;
import com.piuna.CartaoVacinaOnline.repository.UsuarioRepository;
import com.piuna.CartaoVacinaOnline.repository.VacinaRepository;
import com.piuna.CartaoVacinaOnline.service.UsuarioService;
import com.piuna.CartaoVacinaOnline.service.VacinaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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
    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}
