package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.domain.Conexao;
import br.com.cwi.crescer.bascrescer.repository.ConexaoRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.service.BuscarUsuarioService;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static br.com.cwi.crescer.bascrescer.domain.Situacao.AMIZADE;

@Service
public class DesfazerAmizadeService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private ConexaoRepository conexaoRepository;

    @Autowired
    private ValidarConexaoService validarConexaoService;


    public void desfazer(Long id) {

        Usuario solicitante = usuarioAutenticadoService.get();

        Usuario solicitado = buscarUsuarioService.porId(id);

        Conexao conexao = conexaoRepository.findBySolicitadoIdAndSolicitadorIdAndSituacao
                (solicitado.getId(), solicitante.getId(), AMIZADE);

        if (Objects.isNull(conexao))
            conexao = conexaoRepository.findBySolicitadoIdAndSolicitadorIdAndSituacao
                    (solicitante.getId(), solicitado.getId(), AMIZADE);

        validarConexaoService.validarFimAmizade(conexao);

        conexaoRepository.delete(conexao);
    }
}
