import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function detalharUsuario({ id }) {
  const response = await axiosInstance.get(`${API_URL}/usuarios/${id}`);

  return response.data;
}
