package com.thymeleaf.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        List<Prods> prods = new ArrayList<>();
        Prods prods1 = new Prods();
        prods1.setName("aaa");
        prods1.setPrice(1.0);
        prods.add(prods1);

        Prods prods2 = new Prods();
        prods2.setName("bbb");
        prods2.setPrice(1111.0);
        prods.add(prods2);

        Prods prods3 = new Prods();
        prods3.setName("ccc");
        prods3.setPrice(2222);
        prods.add(prods3);

        model.addAttribute("prods",prods);
        return "hello";
    }

    class Prods{
        String name;
        double price;

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
