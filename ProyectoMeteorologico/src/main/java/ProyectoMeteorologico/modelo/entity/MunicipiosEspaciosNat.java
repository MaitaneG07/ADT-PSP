package ProyectoMeteorologico.modelo.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "municipios_espacios_nat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MunicipiosEspaciosNat implements Serializable {

	private static final long serialVersionUID = -4882092065927222320L;
	
	@EmbeddedId
	private MunicipiosEspaciosNatId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESPACIO", insertable = false, updatable = false)
	private EspaciosNaturales espaciosNaturales;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MUNICIPIO", insertable = false, updatable = false)
	private Municipio municipio;
	
	public EspaciosNaturales getEspaciosNaturales() {
		return espaciosNaturales;
	}

}