import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function realizarPostagem({
  visualizacao,
  titulo,
  img,
  conteudo,
}) {
  const response = await axiosInstance.post(`${API_URL}/postagens`, {
    visualizacao,
    titulo,
    img,
    conteudo,
  });

  return response.data;
}
