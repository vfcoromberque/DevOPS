import "./postagem-form.style.css";
import { useState } from "react";
import { useToastr } from "../../../hooks/toastr/use-toastr";
import { realizarPostagem } from "../../../api/postagem/realizar-postagem.api";
import { Botao } from "../botao/botao.component";

export function PostagemForm() {
  const toastr = useToastr();
  const [formInput, setFormInput] = useState({
    visualizacao: "PUBLICO",
    titulo: "",
    img: "",
    conteudo: "",
  });

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await realizarPostagem({
        visualizacao: formInput.visualizacao,
        titulo: formInput.titulo,
        img: formInput.img,
        conteudo: formInput.conteudo,
      });
      toastr({ message: "Postagem realizada", success: true });
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }

  return (
    <div className="post_case">
      <h1>Postar</h1>
      <form className="post_form" action="">
        <input
          name="titulo"
          value={formInput.titulo}
          placeholder="Titulo"
          type="text"
          onChange={handleChange}
          required
        />
        <input
          name="img"
          value={formInput.img}
          placeholder="Imagem (URL)"
          type="text"
          onChange={handleChange}
        />
        <input
          name="conteudo"
          value={formInput.conteudo}
          placeholder="Conteudo"
          type="text"
          onChange={handleChange}
          required
        />
        <select
          value={formInput.visualizacao}
          name="visualizacao"
          id=""
          onChange={handleChange}
        >
          <option value="PUBLICO">Publica</option>
          <option value="PRIVADO">Privada</option>
        </select>
        <Botao text="Postar" onClick={handleSubmit}></Botao>
      </form>
    </div>
  );
}
