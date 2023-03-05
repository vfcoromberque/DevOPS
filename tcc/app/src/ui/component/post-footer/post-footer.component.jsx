import "./post-footer.style.css";
import { numeroCurtidas } from "../../../api/postagem/numero-curtidas.api";
import { curtirPostagem } from "../../../api/postagem/curtir-postagem.api";
import { useState, useEffect } from "react";
import { Botao } from "../botao/botao.component";
import { useToastr } from "../../../hooks/toastr/use-toastr";
import { Comentar } from "../realizar-comentario/realizar-comentario.component";
import { descurtirPostagem } from "../../../api/postagem/descurtir-postagem.api";

export function PostFooter({ post }) {
  const toastr = useToastr();
  const [curtidas, setCurtidas] = useState(null);

  async function onClickCurtir(id) {
    try {
      await curtirPostagem({ id });
      setCurtidas((oldCurtidas) => ++oldCurtidas);
      toastr({ message: "Curtida realizada", success: true });
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }

  async function onClickDescurtir(id) {
    try {
      await descurtirPostagem({ id });
      setCurtidas((oldCurtidas) => --oldCurtidas);
      toastr({ message: "Descurtir realizada", success: true });
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }

  async function pegarCurtidas() {
    try {
      const likes = await numeroCurtidas(post.id);
      setCurtidas(likes);
    } catch (error) {
      toastr({ message: error.message, success: false });
    }
  }

  useEffect(() => {
    pegarCurtidas();
  }, []);

  return (
    <div className="post_footer">
      <div className="post_coment">
        <Comentar post={post}></Comentar>
      </div>
      <Botao text="Curtir" onClick={() => onClickCurtir(post.id)}></Botao>
      <Botao text="Descurtir" onClick={() => onClickDescurtir(post.id)}></Botao>
      <h2>{curtidas}</h2>
    </div>
  );
}
