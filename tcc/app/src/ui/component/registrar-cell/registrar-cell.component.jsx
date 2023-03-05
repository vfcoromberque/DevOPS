import "./registrar-cell.style.css";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import { useGetTimes } from "../../../hooks";
import { Botao } from "../botao/botao.component";
import { registrar } from "../../../api/usuario/registrar.api";

export function RegisterCell() {
  const { times } = useGetTimes();
  const [user, setUser] = useState();
  const navigate = useNavigate();

  const [formInput, setFormInput] = useState({
    nome: "",
    email: "",
    apelido: null,
    dataNascimento: null,
    senha: "",
    img: null,
    timeId: 0,
  });

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();
    try {
      const user = await registrar({
        nome: formInput.nome,
        email: formInput.email,
        apelido: formInput.apelido,
        dataNascimento: formInput.dataNascimento,
        senha: formInput.senha,
        img: formInput.img,
        timeId: formInput.timeId,
      });
      setUser(user);
    } catch (error) {
      console.log("erro");
    }
  }

  useEffect(() => {
    if (user) {
      navigate("/");
    }
  });

  return (
    <div className="register_cell">
      <h1>Registrar</h1>
      <form className="register_cell_form" action="" onSubmit={handleSubmit}>
        <label htmlFor="">Nome Completo</label>
        <input required name="nome" type="text" onChange={handleChange} />
        <label htmlFor="">Email</label>
        <input required name="email" type="text" onChange={handleChange} />
        <label htmlFor="">Apelido</label>
        <input name="apelido" type="text" onChange={handleChange} />
        <label htmlFor="">Data de Nascimento</label>
        <input
          required
          name="dataNascimento"
          type="date"
          onChange={handleChange}
        />
        <label htmlFor="">Senha</label>
        <input required name="senha" type="password" onChange={handleChange} />
        <label htmlFor="">Imagem de Perfil {"(URL)"}</label>
        <input name="img" type="text" onChange={handleChange} />
        <label required htmlFor="">
          Time
        </label>
        <select name="timeId" id="" onChange={handleChange}>
          {times
            ? times.map((time) => (
                <option key={time.id} value={time.id}>
                  {time.nome}
                </option>
              ))
            : null}
          <option value=""></option>
        </select>
        <Botao text="Registrar"></Botao>
      </form>
    </div>
  );
}
