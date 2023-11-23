package com.example.producto1.Model

class Usuario {
    var nombre = ""
    var apellido = ""
    var email = ""

    constructor()

    constructor(nombre: String, apellido: String, email: String) {
        this.nombre = nombre
        this.apellido = apellido
        this.email = email
    }
}