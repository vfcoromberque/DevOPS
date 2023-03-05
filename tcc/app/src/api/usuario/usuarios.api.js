import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function listarUsuarios({ filtro }) {
  const response = await axiosInstance.get(
    `${API_URL}/usuarios?text=${filtro}`
  );
  return response.data.content;
}
