package classes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "professor", schema = "public", catalog = "autoescola")
public class ProfessorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dni")
    private String dni;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "data_i")
    private String dataI;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDataI() {
        return dataI;
    }

    public void setDataI(String dataI) {
        this.dataI = dataI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorEntity that = (ProfessorEntity) o;
        return Objects.equals(dni, that.dni) && Objects.equals(nom, that.nom) && Objects.equals(dataI, that.dataI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nom, dataI);
    }
}
