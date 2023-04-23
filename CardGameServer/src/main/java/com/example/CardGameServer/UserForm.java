package com.example.CardGameServer;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForm {
    @NotBlank(message = "名前を入力してください")
    @Size(min = 2, max = 20, message = "2文字以上20文字以内")
    private String username;

    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 8, max = 20, message = "8文字以上20文字以内")
    private String password;

    @NotBlank(message = "もう1度同じパスワードを入力してください")
    @Size(min = 8, max = 20, message = "8文字以上20文字以内")
    private String confirmPassword;

    @AssertTrue
    public boolean isPasswordValid() {
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.equals(confirmPassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
