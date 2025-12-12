package ProyectoMeteorologico.modelo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "provincias")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Provincia implements Serializable {
	
	private static final long serialVersionUID = -5525908594051990651L;

	@Id
	@Column(name = "ID_PROVINCIA")
	private Integer idProvincia;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Municipio> municipios = new HashSet<>();
	
	public Integer getIdProvincia() {
	    return idProvincia;
	}

	@Override
	public String toString() {
		return nombre;
		
	}
}