package com.stech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ItemController {

    @GetMapping("/items")
    public String itemList(Model model) {
        List<Item> itemList = Arrays.asList(
            new Item("Vidzeme University"),
            new Item("Faculty of Applied Sciences"),
            new Item("Class of Informatic")
        );
        model.addAttribute("itemList", itemList);
        return "items"; 
    }

    public static class Item {
        private String name;

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
