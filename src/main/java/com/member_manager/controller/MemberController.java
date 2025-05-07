package com.member_manager.controller;

import com.member_manager.DTO.MemberSigninDTO;
import com.member_manager.DTO.MemberSignupDTO;
import com.member_manager.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private final  MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("member")
    public String getMain() {
        return "member";
    }

    @GetMapping("member-signup")
    public String getSignUp() {
        return "member-signup";
    }
    
    @GetMapping("member-signin")
    public String getSignIn() {
        return "member-signin";
    }

    @GetMapping("member-signout")
    public String getSignout() {
        return "member-signout";
    }

    @PostMapping("member-signup-service")
    public String postSignup(@RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String nickname,
                             @RequestParam String name,
                             @RequestParam String phone,
                             Model model) {

        MemberSignupDTO memberSignupDTO = new MemberSignupDTO(email, password, nickname, name, phone);
        String msg = memberService.JoinMember(memberSignupDTO) > 0 ?
                "회원가입 성공" : "회원가입 실패";


        return "member-alertmsg";
    }

    @PostMapping("member-signin-service")
    public String postSignin(@RequestParam String email,
                             @RequestParam String password,
                             Model model) {
        MemberSigninDTO memberSigninDTO = new MemberSigninDTO(email, password);
        String msg = memberService.

        model.addAttribute("msg", msg);
        return "member-alertmsg";
    }
}


