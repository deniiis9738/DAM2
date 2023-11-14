package classes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "examen", schema = "public", catalog = "autoescola")
@IdClass(classes.ExamenEntityPK.class)
public class ExamenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "dni")
    private String dni;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "data")
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Basic
    @Column(name = "qualificacio")
    private Float qualificacio;

    public Float getQualificacio() {
        return qualificacio;
    }

    public void setQualificacio(Float qualificacio) {
        this.qualificacio = qualificacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamenEntity that = (ExamenEntity) o;
        return Objects.equals(dni, that.dni) && Objects.equals(data, that.data) && Objects.equals(qualificacio, that.qualificacio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, data, qualificacio);
    }
}
