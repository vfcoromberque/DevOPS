import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function realizarComentario({ conteudo, id }) {
  const response = await axiosInstance.post(
    `${API_URL}/comentarios/postagem/${id}`,
    {
      conteudo,
    }
  );

  return response.data;
}
