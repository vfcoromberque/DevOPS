import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function listarAmigos({ filtro }) {
  const response = await axiosInstance.get(
    `${API_URL}/conexoes/amigos?text=${filtro}`
  );
  return response.data.content;
}
