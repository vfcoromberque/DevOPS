import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function listarSolicitacoes() {
  const response = await axiosInstance.get(`${API_URL}/conexoes/solicitacoes`);
  return response.data;
}
