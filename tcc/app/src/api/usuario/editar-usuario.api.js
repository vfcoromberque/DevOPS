import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function editar({ nome, apelido, img }) {
  const response = await axiosInstance.put(`${API_URL}/usuarios`, {
    nome,
    apelido,
    img,
  });

  return response.data;
}
