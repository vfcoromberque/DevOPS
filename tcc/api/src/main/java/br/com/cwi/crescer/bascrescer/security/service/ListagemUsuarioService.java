package br.com.cwi.crescer.bascrescer.security.service;

import br.com.cwi.crescer.bascrescer.security.controller.response.ListagemUsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.mapper.ListagemUsuarioMapper;
import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListagemUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Page<ListagemUsuarioResponse> listar(String text, Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        return usuarioRepository.findBuscarUsuariosFiltrados(usuario.getId(), text.toLowerCase(), pageable)
                .map(ListagemUsuarioMapper::toResponse);
    }
}
