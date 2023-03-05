import "./card-usuario.style.css";
import { Botao } from "../botao/botao.component";
import { aceitarAmizade } from "../../../api/conexao/aceitar-amizade.api";
import { recusarAmizade } from "../../../api/conexao/recusar-amizade.api";
import { desfazerAmizade } from "../../../api/conexao/desfazer-amizade.api";
import { solicitarAmizade } from "../../../api/conexao/solicitar-amizade.api";
import { useToastr } from "../../../hooks/toastr/use-toastr";
import { Link } from "react-router-dom";

export function CardUsuario({ usuario, tipo }) {
  const toastr = useToastr();

  async function onClickAceitar(id) {
    try {
      await aceitarAmizade({ id });
      toastr({ message: "Pedido Aceito", success: true });
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }
  async function onClickRecusar(id) {
    try {
      await recusarAmizade({ id });
      toastr({ message: "Pedido Recusado", success: true });
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }
  async function onClickDesfazer(id) {
    try {
      await desfazerAmizade({ id });
      toastr({ message: "Amizade Desfeita", success: true });
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }
  async function onClickSolicitar(id) {
    try {
      await solicitarAmizade({ id });
      toastr({ message: "Solicitação Enviada", success: true });
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }

  return (
    <div className="card">
      <Link to="/usuario/perfil" state={{ usuario }} className="card_info">
        <div className="card_img">
          {usuario.img == null ? (
            <img
              src="https://www.fiscalti.com.br/wp-content/uploads/2021/02/default-user-image-365x365.png"
              alt=""
            />
          ) : (
            <img src={usuario.img} alt="" />
          )}
        </div>
        <div className="card_content">
          <h3>{usuario.nome}</h3>
          <p>{usuario.email}</p>
        </div>
      </Link>
      <div className="card_buttons">
        {tipo === "pesquisar" ? (
          <Botao
            text="Solicitar"
            onClick={() => onClickSolicitar(usuario.id)}
          ></Botao>
        ) : null}
        {tipo === "amigos" ? (
          <Botao
            text="Desfazer"
            onClick={() => onClickDesfazer(usuario.id)}
          ></Botao>
        ) : null}
        {tipo === "solicitacoes" ? (
          <>
            <Botao
              text="Aceitar"
              onClick={() => onClickAceitar(usuario.id)}
            ></Botao>
            <Botao
              text="Recusar"
              onClick={() => onClickRecusar(usuario.id)}
            ></Botao>
          </>
        ) : null}
      </div>
    </div>
  );
}
