package ProyectoMeteorologico.modelo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "centros_meteorologicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CentroMeteorologico implements Serializable {
	
	private static final long serialVersionUID = -826048818372657632L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CENTRO_MET")
	private Integer idCentroMet;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MUNICIPIO")
	private Municipio municipio;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "LATITUD")
	private Double latitud;
	
	@Column(name = "LONGITUD")
	private Double longitud;
	
	@Column(name = "URL")
	private String url;
	
	@Column(name = "HASH")
	private String hash;
	
	@OneToMany(mappedBy = "centrosMeteorologicos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MedicionesCentroMet> medicionesCentroMets = new HashSet<>();
	
	public int getIdCentro() {
		return idCentroMet;
	}
	
	public String getNombre() {
		return nombre;
	}
}