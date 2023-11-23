package com.example.producto1.Controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/params")
class RequestParamController {
    @GetMapping("/")
    fun Index(): String {
        return "Index"
    }

    @GetMapping("/string")
    fun param(@RequestParam(name = "texto", required = false, defaultValue = "algun valor...") texto: String, model: Model): String {
        model.addAttribute("resultado", "El texto enviado es: $texto")
        return "ver"
    }
}