import { useState } from "react";
import styles from "./LoginPage.module.css";
import logo from "../../../assets/logo.png";

export default function LoginPage() {
  const [showPassword, setShowPassword] = useState(false);
  const [message, setMessage] = useState("");
  async function handleSubmit(event) {
    event.preventDefault();

    const formData = new FormData(event.currentTarget);

    const loginData = {
      email: formData.get("email"),
      password: formData.get("password"),
      rememberMe: formData.get("rememberMe") === "on",
    };

    try {
      const response = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email: loginData.email,
          password: loginData.password,
        }),
      });

      if (!response.ok) {
        setMessage(`Đăng nhập thất bại (${response.status})`);
        return;
      }

      const account = await response.json();
      console.log("Dữ liệu BE trả về:", account);
      setMessage("Đăng nhập thành công!");
    } catch (error) {
      console.error(error);
      setMessage("Không thể kết nối đến máy chủ.");
    }
  }

  return (
    <main className={styles.mainContainer}>
      <section className={styles.containerForm} aria-labelledby="login-title">
        <header className={styles.formHeader}>
          <img className={styles.logo} src={logo} alt="iLeande" />
          <h1 id="login-title">Chào mừng đến với Trọ Ấm</h1>

          <p>Đăng nhập để tiếp tục quản lý nhà trọ của bạn.</p>
        </header>

        <form className={styles.form} onSubmit={handleSubmit}>
          <div className="form-group">
            <label className="form-label" htmlFor="email">
              Email
            </label>

            <input
              className="form-control"
              id="email"
              name="email"
              type="email"
              placeholder="Nhập email của bạn"
              autoComplete="username"
              required
            />
          </div>

          <div className="form-group">
            <label className="form-label" htmlFor="password">
              Mật khẩu
            </label>

            <div className={styles.passwordField}>
              <input
                className="form-control"
                id="password"
                name="password"
                type={showPassword ? "text" : "password"}
                placeholder="Nhập mật khẩu"
                autoComplete="current-password"
                required
              />

              <button
                className={styles.passwordToggle}
                type="button"
                onClick={() => setShowPassword(!showPassword)}
                aria-controls="password"
                aria-pressed={showPassword}
                aria-label={showPassword ? "Ẩn mật khẩu" : "Hiện mật khẩu"}
              >
                {showPassword ? "Ẩn" : "Hiện"}
              </button>
            </div>
          </div>

          <div className={styles.formOptions}>
            <label className={styles.rememberMe}>
              <input name="rememberMe" type="checkbox" defaultChecked />
              <span>Ghi nhớ đăng nhập</span>
            </label>

            <a className={styles.forgotPassword} href="/forgot-password">
              Quên mật khẩu?
            </a>
          </div>

          <button
            className={`btn btn-primary ${styles.submitButton}`}
            type="submit"
          >
            Đăng nhập
          </button>
        </form>

        <footer className={styles.formFooter}>
          <p>Các tài khoản do chủ trọ mời cho người thuê.</p>
          <p>Sử dụng chung một hệ thống, đăng nhập theo vai trò được cấp.</p>
        </footer>
      </section>
    </main>
  );
}
