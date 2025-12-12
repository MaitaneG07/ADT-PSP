package ProyectoMeteorologico.modelo.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MunicipiosEspaciosNatId implements Serializable {

	private static final long serialVersionUID = 7411651692183639630L;
	
	@Column(name = "ID_ESPACIO")
	private int idEspacio;
	
	@Column(name = "ID_MUNICIPIO")
	private int idMunicipio;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MunicipiosEspaciosNatId)) return false;
        MunicipiosEspaciosNatId that = (MunicipiosEspaciosNatId) o;
        return idEspacio == that.idEspacio &&
               idMunicipio == that.idMunicipio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEspacio, idMunicipio);
    }
}