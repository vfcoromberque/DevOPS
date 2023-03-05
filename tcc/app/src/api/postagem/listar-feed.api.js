import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function listarFeed() {
  const response = await axiosInstance.get(
    `${API_URL}/postagens/feed?sort=dataPostagem,desc`
  );
  return response.data.content;
}
