package com.member_manager.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class MemberSignupDTO {

    @NotNull(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식을 확인해주세요")
    private String email;
    @NotNull(message = "비밀번호를 입력해주세요")
    private String password;
    @NotNull(message = "닉네임을 입력해주세요")
    private String nickname;
    @NotNull(message = "이름을 입력해주세요")
    private String name;
    @NotNull(message = "전화번호를 입력해주세요")
    private String phone;

    public MemberSignupDTO() {
    }

    public MemberSignupDTO(String email, String password, String nickname, String name, String phone) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.phone = phone;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
