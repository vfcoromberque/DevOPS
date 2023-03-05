import "./login.style.css";
import { ScreenWrapper } from "../../component";
import { LoginCell } from "../../component";

export function Login() {
  return (
    <ScreenWrapper>
      <div className="login_screen">
        <LoginCell />
      </div>
    </ScreenWrapper>
  );
}
