package com.wildcodeschool.myProjectWithSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello World!!!";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Hello Admin!!!";
    }

    @GetMapping("/avengers/assemble")
    @ResponseBody
    public String avengers(){
        return "Avengers... Assemble";
    }
    @GetMapping("/secret-bases")
    @ResponseBody
    public String secretBases(){
        return "Biaritz, Bordeaux, La Loupe, Lille, Lyon, Marseille, Nantes, Orléans, Paris, Reims, Strasbourg, Toulouse, Tours";
    }
}
