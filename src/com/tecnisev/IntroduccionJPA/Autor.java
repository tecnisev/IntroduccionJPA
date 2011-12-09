package com.tecnisev.IntroduccionJPA;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
* @autor Administrator
*
*/
@Entity
@Table(name="autor")
public class Autor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	/**
	* @return the id
	*/
	public int getId() {
		return id;
	}
	
	/**
	* @param id the id to set
	*/
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="autorName", nullable=false, length=50, insertable=true)
	private String autorName;
	
	/**
	* @return the autorName
	*/
	public String getautorName() {
		return autorName;
	}
	
	/**
	* @param autorName the autorName to set
	*/
	public void setautorName(String autorName) {
		this.autorName = autorName;
	}
	
	//for joing the tables (many-to-many)
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "autor_libro",
			   joinColumns = {@JoinColumn(name="autorId")},
					           inverseJoinColumns = {@JoinColumn(name="libroId")}
		       )
	private Set<Libro> libros;
	
	/**
	* @return the libros
	*/
	public Set<Libro> getlibros() {
		return libros;
	}
	
	/**
	* @param libros the libros to set
	*/
	public void setlibros(Set<Libro> libros) {
		this.libros = libros;
	}


}