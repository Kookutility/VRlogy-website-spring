package com.example.demo.controller;

import com.example.demo.domain.MemberInfo;
import com.example.demo.service.SignUpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
@Controller
public class SignUpController {

    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "signup"; // signup과 매칭될 것입니다.
    }

    @PostMapping("/signup")
    @ResponseBody
    public Map<String, String> handleSignUp(@RequestParam("username") String username,
                                            @RequestParam("password") String password,
                                            @RequestParam(value = "confirmPassword", required = false) String confirmPassword)  {
        Map<String, String> response = new HashMap<>();


        if (signUpService.isUsernameAlreadyTaken(username)) {
            response.put("result", "duplicate");
            return response;
        }

        MemberInfo member = new MemberInfo();
        member.setUsername(username);
        member.setPassword(password);

        signUpService.signUp(member);

        response.put("result", "success");

        return response; // 회원가입 성공 시 success 메시지 반환
    }
}

