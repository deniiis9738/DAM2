package classes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "practiques", schema = "public", catalog = "autoescola")
@IdClass(classes.PractiquesEntityPK.class)
public class PractiquesEntity {
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
    @Column(name = "cotxe")
    private String cotxe;

    public String getCotxe() {
        return cotxe;
    }

    public void setCotxe(String cotxe) {
        this.cotxe = cotxe;
    }

    @Basic
    @Column(name = "km")
    private Short km;

    public Short getKm() {
        return km;
    }

    public void setKm(Short km) {
        this.km = km;
    }

    @Basic
    @Column(name = "val")
    private Float val;

    public Float getVal() {
        return val;
    }

    public void setVal(Float val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PractiquesEntity that = (PractiquesEntity) o;
        return Objects.equals(dni, that.dni) && Objects.equals(data, that.data) && Objects.equals(cotxe, that.cotxe) && Objects.equals(km, that.km) && Objects.equals(val, that.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, data, cotxe, km, val);
    }
}
