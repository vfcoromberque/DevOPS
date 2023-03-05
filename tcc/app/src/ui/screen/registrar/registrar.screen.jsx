import "./registrar.style.css";
import { ScreenWrapper } from "../../component";
import { RegisterCell } from "../../component/registrar-cell/registrar-cell.component";

export function Register() {
  return (
    <ScreenWrapper>
      <div className="register_screen">
        <RegisterCell />
      </div>
    </ScreenWrapper>
  );
}
