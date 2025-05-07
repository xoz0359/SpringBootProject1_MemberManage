package com.member_manager.domain;

public class Member {
    private int id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phone;
    private int access;

    public Member() {
    }

    public Member(int access, String phone, String nickname, String name, String password, String email, int id) {
        this.access = access;
        this.phone = phone;
        this.nickname = nickname;
        this.name = name;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhone() {
        return phone;
    }

    public int getAccess() {
        return access;
    }
}
