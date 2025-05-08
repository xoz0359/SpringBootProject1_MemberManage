package com.member_manager.controller;

import com.member_manager.DTO.MemberSigninDTO;
import com.member_manager.DTO.MemberSignupDTO;
import com.member_manager.domain.Member;
import com.member_manager.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public String postSignup(@ModelAttribute
            @Valid MemberSignupDTO memberSignupDTO,
                             BindingResult bindingResult,
                             Model model) {
        if(bindingResult.hasErrors()) {
            List<String> errorMessages
                    = bindingResult.getAllErrors()//
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            String error = String.join("\n", errorMessages);
            model.addAttribute("msg", error);
            return "member-alertmsg";
        }
        String msg = memberService.JoinMember(memberSignupDTO) > 0 ?
                "회원가입 성공" : "회원가입 실패";
        model.addAttribute("msg", msg);
        return "member-alertmsg";
    }

    @PostMapping("member-signin-service")
    public String postSignin(@ModelAttribute
            @Valid MemberSigninDTO memberSigninDTO,
                             BindingResult bindingResult,// bindingResult는 @valid 메서드 바로 뒤에 위치해야 함
                             Model model,
                             HttpSession session) {

        if(bindingResult.hasErrors()) {// DTO의 어노테이션에서 Field에러를 감지했으면 true를 반환
            List<String> errorMessages
                    = bindingResult.getAllErrors()// List<ObjectError> 타입으로 인스턴스 제공
                    .stream()// 데이터 변환을 위해 stream으로 변환
                    .map(ObjectError::getDefaultMessage)// :: 메서드 참조식으로 람다식을 더 줄여서 표현한 것
                                                        // ObjectError에서 getDefaltMessage()로 발생한 데이터를 수집한다는 의미
                    .collect(Collectors.toList());// 수집된 데이터를 List<String> 타입으로 가공해서 저장

            String error = String.join("\n", errorMessages); //String error에 List<String>의 모든 문자열을 "/n"를 구분자 삼아 연결
            model.addAttribute("msg", error);
            return "member-alertmsg";
        }
        Optional<Member> optinalmember = memberService.loginMember(memberSigninDTO);
        String msg = "로그인 실패";
        if (optinalmember.isPresent()) {
            model.addAttribute("member", optinalmember.get());
            session.setAttribute("member", optinalmember.get());
            msg = "로그인 성공";
        }
            model.addAttribute("msg", msg);
        return "member-alertmsg";
    }
    @GetMapping("member-signout-service")
    public String getSignout(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }
}


