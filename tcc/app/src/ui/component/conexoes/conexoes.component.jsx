import "./conexoes.style.css";
import { Botao } from "../botao/botao.component";
import { useState, useEffect } from "react";
import { useGetAmigos } from "../../../hooks/conexoes/listar-amigos.hook";
import { ListarUsuarios } from "../listar-usuarios/listar-usuarios.component";
import { useGetSolicitacoes } from "../../../hooks/conexoes/listar-solicitacoes.hook";
import { useGetUsuarios } from "../../../hooks/usuarios/listar-usuarios.hook";

export function Conexoes() {
  const [formInput, setFormInput] = useState({ input: "" });
  const { usuarios, buscandoUsuarios } = useGetUsuarios(formInput.input);
  const { solicitacoes, buscandoSolicitacoes } = useGetSolicitacoes();
  const { amigos, buscandoAmigos } = useGetAmigos(formInput.input);
  const [lista, setLista] = useState();
  const [tipo, setTipo] = useState("amigos");

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  function onClickAmigos() {
    buscandoAmigos();
    setLista(amigos);
    setTipo("amigos");
  }

  function onClickSolicitacoes() {
    buscandoSolicitacoes();
    setLista(solicitacoes);
    setTipo("solicitacoes");
  }

  function onClickPesquisar() {
    buscandoUsuarios();
    setLista(usuarios);
    setTipo("pesquisar");
  }

  useEffect(() => {
    if (tipo === "amigos") {
      buscandoAmigos();
    }
    if (tipo === "pesquisar") {
      buscandoUsuarios();
    }
  }, [formInput]);

  useEffect(() => {
    setLista(amigos);
  }, [amigos]);

  return lista ? (
    <div className="connection_tab">
      <nav className="connection_tab_nav">
        <Botao text="Amigos" onClick={onClickAmigos}></Botao>
        <Botao text="Solicitacoes" onClick={onClickSolicitacoes}></Botao>
        <Botao text="Pesquisar" onClick={onClickPesquisar}></Botao>
      </nav>
      <div className="connection_tab_list">
        <ListarUsuarios
          tipo={tipo}
          lista={lista}
          formInput={formInput}
          handleChange={handleChange}
        ></ListarUsuarios>
      </div>
    </div>
  ) : null;
}
