package com.example.producto1.Controller


import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HomeController {
    @GetMapping("/home")
    fun home(@RequestParam(name = "nombre", required = true, defaultValue = "Denis") nombre: String, model: Model): String {
        model.addAttribute("nombre", nombre)
        return "home"
    }
}