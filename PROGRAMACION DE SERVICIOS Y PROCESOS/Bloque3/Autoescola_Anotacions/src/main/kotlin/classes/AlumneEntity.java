package classes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "alumne", schema = "public", catalog = "autoescola")
public class AlumneEntity {
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

    @Basic
    @Column(name = "nom")
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "data_n")
    private String dataN;

    public String getDataN() {
        return dataN;
    }

    public void setDataN(String dataN) {
        this.dataN = dataN;
    }

    @Basic
    @Column(name = "dni_p")
    private String dniP;

    public String getDniP() {
        return dniP;
    }

    public void setDniP(String dniP) {
        this.dniP = dniP;
    }

    @Basic
    @Column(name = "dia_c")
    private String diaC;

    public String getDiaC() {
        return diaC;
    }

    public void setDiaC(String diaC) {
        this.diaC = diaC;
    }

    @Basic
    @Column(name = "hora_c")
    private Double horaC;

    public Double getHoraC() {
        return horaC;
    }

    public void setHoraC(Double horaC) {
        this.horaC = horaC;
    }

    @Basic
    @Column(name = "aprovat")
    private String aprovat;

    public String getAprovat() {
        return aprovat;
    }

    public void setAprovat(String aprovat) {
        this.aprovat = aprovat;
    }

    @Basic
    @Column(name = "baixa")
    private String baixa;

    public String getBaixa() {
        return baixa;
    }

    public void setBaixa(String baixa) {
        this.baixa = baixa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumneEntity that = (AlumneEntity) o;
        return Objects.equals(dni, that.dni) && Objects.equals(nom, that.nom) && Objects.equals(dataN, that.dataN) && Objects.equals(dniP, that.dniP) && Objects.equals(diaC, that.diaC) && Objects.equals(horaC, that.horaC) && Objects.equals(aprovat, that.aprovat) && Objects.equals(baixa, that.baixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nom, dataN, dniP, diaC, horaC, aprovat, baixa);
    }
}
