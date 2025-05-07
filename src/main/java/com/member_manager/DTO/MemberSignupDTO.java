package com.member_manager.DTO;

public class MemberSignupDTO {

    private String email;
    private String password;
    private String Nickname;
    private String name;
    private String phone;

    public MemberSignupDTO(String email, String password, String nickname, String name, String phone) {
        this.email = email;
        this.password = password;
        this.Nickname = nickname;
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
        return Nickname;
    }

    public void setNickname(String nickname) {
        this.Nickname = nickname;
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
