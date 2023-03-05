import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function listarTimes() {
  const response = await axiosInstance.get(`${API_URL}/times/publico`);
  return response.data;
}
