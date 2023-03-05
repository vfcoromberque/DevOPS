import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function logout() {
  await axiosInstance.post(`${API_URL}/logout`, {});
}
