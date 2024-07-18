package com.sahil.AtmInterface.controller;


import com.sahil.AtmInterface.model.ATM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AtmController {

    @Autowired
    private ATM atm;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("balance",atm.checkBalance());
        return "index";
    }

    @PostMapping("/atm/Deposit")
    public String deposit(@RequestParam double amount,Model model){
        atm.deposit(amount);
        model.addAttribute("message","Amount Deposited Successfully. New Balance is "+atm.checkBalance());
        model.addAttribute("balance",atm.checkBalance());
        return "index";
    }

    @PostMapping("/atm/Withdraw")
    public String Withdraw(@RequestParam double amount,Model model){
        String result=atm.withdraw(amount);
        model.addAttribute("message",result);
        model.addAttribute("balance",atm.checkBalance());
        return "index";
    }
}
