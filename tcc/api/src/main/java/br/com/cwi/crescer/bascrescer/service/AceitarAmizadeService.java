package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;
import br.com.cwi.crescer.bascrescer.domain.Conexao;
import br.com.cwi.crescer.bascrescer.domain.Situacao;
import br.com.cwi.crescer.bascrescer.mapper.IdResponseMapper;
import br.com.cwi.crescer.bascrescer.repository.ConexaoRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.service.BuscarUsuarioService;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.crescer.bascrescer.domain.Situacao.SOLICITADO;

@Service
public class AceitarAmizadeService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private ConexaoRepository conexaoRepository;

    @Autowired
    private ValidarConexaoService validarConexaoService;


    public IdResponse aceitar(Long id) {

        Usuario solicitado = usuarioAutenticadoService.get();

        Usuario solicitador = buscarUsuarioService.porId(id);

        Conexao conexao = conexaoRepository.findBySolicitadoIdAndSolicitadorIdAndSituacao
                (solicitado.getId(), solicitador.getId(), SOLICITADO);

        validarConexaoService.validarAceitacao(conexao);

        conexao.setSituacao(Situacao.AMIZADE);

        conexaoRepository.save(conexao);

        return IdResponseMapper.toResponse(conexao.getId());

    }
}
