import "./editar-usuario.style.css";
import { ScreenWrapper } from "../../component";
import { editar } from "../../../api/usuario/editar-usuario.api";
import { useState } from "react";
import { useToastr } from "../../../hooks/toastr/use-toastr";
import { Botao } from "../../component";

export function EditarPerfil() {
  const toastr = useToastr();
  const [formInput, setFormInput] = useState({
    nome: undefined,
    apelido: undefined,
    img: undefined,
  });

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await editar({
        nome: formInput.nome,
        apelido: formInput.apelido,
        img: formInput.img,
      });
      toastr({ message: "Perfil editado", success: true });
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }

  return (
    <ScreenWrapper className="edit">
      <div className="edit_form_cell">
        <form className="edit_form" action="" onSubmit={handleSubmit}>
          <input
            type="text"
            value={formInput.nome}
            name="nome"
            onChange={handleChange}
            placeholder="Nome"
          />
          <input
            type="text"
            value={formInput.apelido}
            name="apelido"
            onChange={handleChange}
            placeholder="Apelido"
          />
          <input
            type="text"
            value={formInput.img}
            name="img"
            onChange={handleChange}
            placeholder="Imagem (URL)"
          />
          <Botao text="Editar"></Botao>
        </form>
      </div>
    </ScreenWrapper>
  );
}
