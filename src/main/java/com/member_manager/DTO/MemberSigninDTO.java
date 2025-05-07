package com.member_manager.DTO;

public class MemberSigninDTO {
    private String email;
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
