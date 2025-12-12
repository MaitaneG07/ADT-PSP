package ProyectoMeteorologico.modelo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espacios_naturales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspaciosNaturales implements Serializable {

	private static final long serialVersionUID = 20153009663153159L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESPACIO")
	private Integer idEspacio;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION", columnDefinition = "TEXT")
	private String descripcion;
	
	@Column(name = "TIPO")
	private String tipo;
	
	@Column(name = "CATEGORIA")
	private String categoria;
	
	@Column(name = "LATITUD")
	private Double latitud;
	
	@Column(name = "LONGITUD")
	private Double longitud;
	
	@OneToMany(mappedBy = "espaciosNaturales", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MunicipiosEspaciosNat> municipiosEspaciosNats = new HashSet<>();
	
	public int getIdEspacio() {
		return idEspacio;
	}
	
	public String getNombre() {
		return nombre;
	}
}