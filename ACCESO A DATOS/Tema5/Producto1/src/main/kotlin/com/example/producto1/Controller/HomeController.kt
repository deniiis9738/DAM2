package com.example.producto1.Controller


import com.example.producto1.Model.Usuario
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/app")
class HomeController {
    @GetMapping("/", "/home", "/index")
    fun home(@RequestParam(name = "nombre", required = true, defaultValue = "Denis") nombre: String, model: Model): String {
        model.addAttribute("nombre", nombre)
        return "home"
    }

    @RequestMapping("/perfil")
    fun perfil(model: Model): String {
        var usuario = Usuario()
        usuario.nombre = "Denis"
        usuario.apellido = "Ion"
        model.addAttribute("usuario", usuario)
        model.addAttribute("titulo", "Perfil de usuario ${usuario.nombre}")
        return "perfil"
    }

    @RequestMapping("/listar")
    fun listar(model: Model): String {
//        var usuarios: MutableList<Usuario> = mutableListOf()
//        usuarios.add(Usuario("Denis", "Ion", "denis@gmail.com"))
//        usuarios.add(Usuario("Geroge", "Popa", "geroge@gmail.com"))
//        usuarios.add(Usuario("Carlos", "Hernandez", "carlos@gmail.com"))
//        model.addAttribute("usuarios", usuarios)
        model.addAttribute("titulo", "Listado de usuarios")
        return "listar"
    }

    @ModelAttribute("usuarios")
    fun poblarUsuarios(): List<Usuario> {
        var usuarios: MutableList<Usuario> = mutableListOf()
        usuarios.add(Usuario("Denis", "Ion", "denis@gmail.com"))
        usuarios.add(Usuario("Geroge", "Popa", "geroge@gmail.com"))
        usuarios.add(Usuario("Carlos", "Hernandez", "carlos@gmail.com"))
        return usuarios
    }
}