package com.CodingDojo.Abraham.Modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2, max=100, message="El nombre debe de tener al menos 2 caracteres")
	private String nombre;
	@NotNull
	@Size(min=2, max=100)
	private String apellido;
	@NotNull
	@Size(min=2, max=200)
	private String email;
	@NotNull
	@Size(min=6, max=255)
	private String password;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateAt;
	
	
	public Usuario() {}
	
	
	// Este ayudara a Crear un nuevo usuario
	public Usuario(String nombre, String apellido, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}


	// Este ayudara a actualizar un usuario
	public Usuario(long id, String nombre, String apellido, String email, String password) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}


	public Usuario(long id, String nombre, String apellido, String email, String password, Date createdAt,
			Date updateAt) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}
	
	// Getters and Setters
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); // DEFAULT CURRENT_TIMESTAMP
	}
	

	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date(); // DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	}
}
