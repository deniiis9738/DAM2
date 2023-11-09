package classes;

import java.util.Collection;
import java.util.Objects;

public class ComarcaEntity {
    private String nomC;
    private String provincia;
    private Collection<PoblacioEntity> poblaciosByNomC;

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComarcaEntity that = (ComarcaEntity) o;
        return Objects.equals(nomC, that.nomC) && Objects.equals(provincia, that.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomC, provincia);
    }

    public Collection<PoblacioEntity> getPoblaciosByNomC() {
        return poblaciosByNomC;
    }

    public void setPoblaciosByNomC(Collection<PoblacioEntity> poblaciosByNomC) {
        this.poblaciosByNomC = poblaciosByNomC;
    }
}
