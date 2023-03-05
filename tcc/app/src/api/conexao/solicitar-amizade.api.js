import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function solicitarAmizade({ id }) {
  await axiosInstance.post(`${API_URL}/conexoes/usuario/${id}`);
}
