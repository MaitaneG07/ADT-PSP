package ProyectoMeteorologico.modelo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicionesCentroMetId implements Serializable {

	private static final long serialVersionUID = -4556075007927280420L;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "HORA")
	private Time hora;
	
	@Column(name = "ID_CENTRO_MET")
	private int idCentroMet;

	public Date getFecha() {
	    return fecha;
	}
	
	public Time getHora() {
	    return hora;
	}
	
	public int getIdCentroMet() {
	    return idCentroMet;
	}
}