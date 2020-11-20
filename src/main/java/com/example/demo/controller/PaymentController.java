package com.example.demo.controller;

import com.example.demo.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PaymentController {
    @Autowired
    private StripeService stripeService;
    // Reading the value from the application.properties file
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @RequestMapping("/pay")
    public String home(Model model) {
        model.addAttribute("amount",  100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "Dioptricglasses";
    }

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public String chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getParameter("data-key");
        return "Dioptricglasses";
    }
}