import "./feed-post.style.css";
import { PostHeader } from "../post-header/post-header.component";
import { PostFooter } from "../post-footer/post-footer.component";
import { ListaComentarios } from "../lista-comentarios/lista-comentarios.component";

export function FeedPost({ post }) {
  return (
    <div className="feed_post">
      <PostHeader usuario={post.usuario}></PostHeader>
      <h1>{post.titulo}</h1>
      <div className="feed_post_img">
        <img src={post.img} alt="" />
      </div>
      <h4>{post.conteudo}</h4>
      <h5>{post.dataPostagem}</h5>
      <PostFooter post={post}></PostFooter>
      <ListaComentarios post={post}></ListaComentarios>
    </div>
  );
}
