package ProyectoMeteorologico.modelo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "municipios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Municipio implements Serializable {
	
	private static final long serialVersionUID = 3929594558240552756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MUNICIPIO")
	private Integer idMunicipio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROVINCIA")
	private Provincia provincia;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION", columnDefinition = "TEXT")
	private String descripcion;
	
	@Column(name = "COD_MUNICIPIO")
	private Integer codMunicipio;
	
	@OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MunicipiosEspaciosNat> municipiosEspaciosNats = new HashSet<>();
	
	@OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<CentroMeteorologico> centrosMeteorologicos = new HashSet<>();

	public int getIdMunicipio() {
		return idMunicipio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}