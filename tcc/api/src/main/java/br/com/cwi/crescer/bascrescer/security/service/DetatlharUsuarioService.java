package br.com.cwi.crescer.bascrescer.security.service;

import br.com.cwi.crescer.bascrescer.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.mapper.DetalharUsuarioMapper;
import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetatlharUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public DetalharUsuarioResponse detalhar(Long id) {

        Usuario usuario = buscarUsuarioService.porId(id);

        return DetalharUsuarioMapper.toResponse(usuario);

    }
}
