package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.security.controller.response.ListagemUsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.mapper.ListagemUsuarioMapper;
import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAmizadesService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Page<ListagemUsuarioResponse> amizades(String text, Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        return usuarioRepository.findUsuariosAmigos(text.toLowerCase(), usuario ,pageable)
                .map(ListagemUsuarioMapper::toResponse);
    }
}
