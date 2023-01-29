package com.example.mvc_converter.controller;

import com.example.mvc_converter.logic.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ConverterController {

    private Converter converter;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/converter")
    public String converter() {
        return "service-form";
    }

    @PostMapping("/converter-handler")
    public String converter(@RequestParam String curToBuy,
                            @RequestParam String curToSell,
                            @RequestParam double amount,
                            RedirectAttributes ra) {

        converter = new Converter(curToBuy, curToSell, amount);

        ra.addFlashAttribute("currency", converter.currencyConverter());

        return "redirect:converter";
    }
}
