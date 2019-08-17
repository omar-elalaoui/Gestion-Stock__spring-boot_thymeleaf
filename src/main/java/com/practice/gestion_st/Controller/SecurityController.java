package com.practice.gestion_st.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @RequestMapping(value = "/login")
    public String login(){
        return "sign_in";
    }
}
