package ProyectoMeteorologico.modelo.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mediciones_centro_met")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicionesCentroMet implements Serializable {

	private static final long serialVersionUID = 64071800526901271L;
	
	@EmbeddedId
	private MedicionesCentroMetId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CENTRO_MET", insertable = false, updatable = false)
	private CentroMeteorologico centrosMeteorologicos;
	
	@Column(name = "DIR_VIENTO")
	private Integer dirViento;
	
	@Column(name = "H_RELATIVA")
	private Integer HRelativa;
	
	@Column(name = "P_ATMOSFERICA")
	private Float PAtmosferica;
	
	@Column(name = "PRECIP")
	private Float precip;
	
	@Column(name = "RAD_SOLAR")
	private Float radSolar;
	
	@Column(name = "TEMP_AMBIENTE")
	private Float tempAmbiente;
	
	@Column(name = "V_VIENTO")
	private Float VViento;
	
	@Column(name = "ICA")
	private String ica;
	
	public MedicionesCentroMetId getId() {
	    return id;
	}

	public CentroMeteorologico getCentrosMeteorologicos() {
	    return centrosMeteorologicos;
	}

	public Integer getDirViento() {
	    return dirViento;
	}

	public Integer getHRelativa() {
	    return HRelativa;
	}

	public Float getPAtmosferica() {
	    return PAtmosferica;
	}

	public Float getPrecip() {
	    return precip;
	}

	public Float getRadSolar() {
	    return radSolar;
	}

	public Float getTempAmbiente() {
	    return tempAmbiente;
	}

	public Float getVViento() {
	    return VViento;
	}

	public String getIca() {
	    return ica;
	}

}