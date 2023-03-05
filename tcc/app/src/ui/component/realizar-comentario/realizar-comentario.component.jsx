import "./realizar-comentario.style.css";
import { Botao } from "../botao/botao.component";
import { realizarComentario } from "../../../api/postagem/realizar-comentario.api";
import { useState } from "react";

export function Comentar({ post }) {
  const [formInput, setFormInput] = useState({ conteudo: "" });

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await realizarComentario({
        conteudo: formInput.conteudo,
        id: post.id,
      });
    } catch (error) {
      console.log("erro");
    }
  }

  return (
    <div>
      <form action="">
        <input
          value={formInput.conteudo}
          name="conteudo"
          onChange={handleChange}
          placeholder="Comentario"
          type="text"
        />
        <Botao text="Comentar" onClick={handleSubmit}></Botao>
      </form>
    </div>
  );
}
