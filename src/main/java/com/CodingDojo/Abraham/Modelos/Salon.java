package com.CodingDojo.Abraham.Modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="salones")
public class Salon {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nombre;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateAt;
	
	
	public Salon() {}
	
	
	@OneToMany(mappedBy="salon", fetch=FetchType.LAZY)
	private List<Usuario> usuarios;
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); // DEFAULT CURRENT_TIMESTAMP
	}
	

	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date(); // DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}

