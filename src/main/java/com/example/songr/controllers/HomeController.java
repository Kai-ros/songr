package com.example.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String getRoot()
    {
        System.out.println("somebody got the root");
        return "helloworld";
    }

    @GetMapping("/sayHello")
    public String getSayHello(@RequestParam(required=false, defaultValue = "friendo") String name, Model model)
    {
        model.addAttribute("firstName", name);
        return "sayHello";
    }

    @GetMapping("/hello")
    public String getHello()
    {
        System.out.println("Hello, World.");
        return "hello";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model)
    {
        model.addAttribute("capitalizedText", text);
        return "capitalize";
    }

    @GetMapping("/reverse")
    public String reverse(@RequestParam(required=false, defaultValue = "Some string of words to reverse") String sentence, Model model)
    {
        model.addAttribute("reversedInput", reverseHelper(sentence));
        return "reverse";
    }

    public static String reverseHelper(String inputToReverse)
    {
        String[] inputMessage = inputToReverse.split(" ");
        String outputMessage = new String();
        for(int i = inputMessage.length - 1; i >= 0; i--){
            outputMessage = outputMessage + inputMessage[i] + " ";
        }
        return outputMessage.trim();
    }
}
