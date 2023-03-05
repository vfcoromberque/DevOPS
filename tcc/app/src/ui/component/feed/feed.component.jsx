import "./feed.style.css";
import { PostagemForm } from "../postagem-form/postagem-form.component";
import { ListaFeed } from "../lista-feed/lista-feed.component";

export function Feed() {
  return (
    <div className="feed_cell">
      <PostagemForm></PostagemForm>
      <ListaFeed></ListaFeed>
    </div>
  );
}
