package org.example.crudhibernate.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="nadador")
public class Nadador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="numFederado", unique = true)
    private String numFederado;
    @Column(name="pais")
    private String pais;
    @Column(name="edad")
    private int edad;
    @Column(name="email", unique = true)
    private String email;

    public Nadador() {

    }

    public Nadador(String nombre, String numFederado, String pais, int edad, String email) {
        this.nombre = nombre;
        this.numFederado = numFederado;
        this.pais = pais;
        this.edad = edad;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumFederado() {
        return numFederado;
    }

    public void setNumFederado(String numFederado) {
        this.numFederado = numFederado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
