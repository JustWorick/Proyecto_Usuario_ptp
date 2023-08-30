package com.CodingDojo.Abraham.Modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="direcciones")
public class Direccion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=100)
	private String calle;
	
	@NotNull
	@Size(min=1, max=5)
	private String numero;
	
	@NotNull
	@Size(min=2, max=100)
	private String ciudad;
	
	@Min(100000)
	@Max(999999)
	private int cp;
	
	@NotNull
	@Size(min=2, max=100)
	private String pais;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateAt;
	
	
	@OneToOne(fetch=FetchType.LAZY) // tipo de relacion
	@JoinColumn(name="usuario_id") // llave foranea
	private Usuario usuario; // objeto usuario al cual me relaciono
	
	
	public Direccion () {}

	public Direccion(@NotNull @Size(min = 2, max = 100) String calle, @NotNull @Size(min = 1, max = 5) String numero,
			@NotNull @Size(min = 2, max = 100) String ciudad, @Min(100000) @Max(999999) int cp,
			@NotNull @Size(min = 2, max = 100) String pais) {
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.cp = cp;
		this.pais = pais;
	}


	
	public Direccion(Long id, @NotNull @Size(min = 2, max = 100) String calle,
			@NotNull @Size(min = 1, max = 5) String numero, @NotNull @Size(min = 2, max = 100) String ciudad,
			@Min(100000) @Max(999999) int cp, @NotNull @Size(min = 2, max = 100) String pais, Date createdAt,
			Date updateAt) {
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.cp = cp;
		this.pais = pais;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); // DEFAULT CURRENT_TIMESTAMP
	}
	

	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date(); // DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}