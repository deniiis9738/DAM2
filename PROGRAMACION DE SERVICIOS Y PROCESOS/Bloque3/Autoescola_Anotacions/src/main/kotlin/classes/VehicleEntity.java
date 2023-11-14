package classes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "vehicle", schema = "public", catalog = "autoescola")
public class VehicleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "matricula")
    private String matricula;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "data_c")
    private String dataC;
    @Basic
    @Column(name = "km")
    private Integer km;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDataC() {
        return dataC;
    }

    public void setDataC(String dataC) {
        this.dataC = dataC;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEntity that = (VehicleEntity) o;
        return Objects.equals(matricula, that.matricula) && Objects.equals(model, that.model) && Objects.equals(dataC, that.dataC) && Objects.equals(km, that.km);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, model, dataC, km);
    }
}
