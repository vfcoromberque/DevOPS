import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function desfazerAmizade({ id }) {
  await axiosInstance.delete(`${API_URL}/conexoes/usuario/${id}/desfazer`);
}
