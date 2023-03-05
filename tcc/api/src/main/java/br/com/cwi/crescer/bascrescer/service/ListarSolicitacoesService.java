package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.repository.ConexaoRepository;
import br.com.cwi.crescer.bascrescer.security.controller.response.ListagemUsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.mapper.ListagemUsuarioMapper;
import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarSolicitacoesService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private ConexaoRepository conexaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<ListagemUsuarioResponse> solicitacoes() {

        Usuario usuario = usuarioAutenticadoService.get();

        return usuarioRepository.findUsuariosSolicitntes(usuario).stream()
                .map(ListagemUsuarioMapper::toResponse).collect(Collectors.toList());
    }
}
