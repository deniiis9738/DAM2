package classes;

import java.util.Objects;

public class InstitutEntity {
    private String codi;
    private String nom;
    private String adreca;
    private String numero;
    private Integer codpostal;
    private Integer codM;
    private PoblacioEntity poblacioByCodM;

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    public Integer getCodM() {
        return codM;
    }

    public void setCodM(Integer codM) {
        this.codM = codM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutEntity that = (InstitutEntity) o;
        return Objects.equals(codi, that.codi) && Objects.equals(nom, that.nom) && Objects.equals(adreca, that.adreca) && Objects.equals(numero, that.numero) && Objects.equals(codpostal, that.codpostal) && Objects.equals(codM, that.codM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codi, nom, adreca, numero, codpostal, codM);
    }

    public PoblacioEntity getPoblacioByCodM() {
        return poblacioByCodM;
    }

    public void setPoblacioByCodM(PoblacioEntity poblacioByCodM) {
        this.poblacioByCodM = poblacioByCodM;
    }
}
