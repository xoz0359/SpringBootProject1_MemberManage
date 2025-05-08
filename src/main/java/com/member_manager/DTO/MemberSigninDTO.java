package com.member_manager.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MemberSigninDTO {
    @NotNull(message = "이메일을 입력해주세요")
    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식을 확인해주세요")
    private String email;
    @NotNull(message = "비밀번호를 입력해주세요")
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    public MemberSigninDTO() {}

    public MemberSigninDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
