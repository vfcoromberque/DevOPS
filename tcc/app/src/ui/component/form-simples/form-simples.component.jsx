import "./form-simples.style.css";
import { Botao } from "../botao/botao.component";

export function SimpleForm({ formInput, handleChange, handleSubmit }) {
  return (
    <form className="login_cell_form" action="" onSubmit={handleSubmit}>
      <label htmlFor="">Email</label>
      <input
        required
        value={formInput.username}
        name="username"
        onChange={handleChange}
        placeholder="Usuario"
      />
      <label htmlFor="">Senha</label>
      <input
        required
        type="password"
        value={formInput.password}
        name="password"
        onChange={handleChange}
        placeholder="Senha"
      />
      <Botao text="Logar"></Botao>
    </form>
  );
}
