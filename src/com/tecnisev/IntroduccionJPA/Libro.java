package com.tecnisev.IntroduccionJPA;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
* @autor Administrator
*
*/
@Entity
@Table(name="libro")
public class Libro 
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
	
	@Column(name="libroName", nullable=false, length=250, insertable=true)
	private String libroName;
	
	/**
	* @return the libroName
	*/
	public String getlibroName() {
	return libroName;
	}
	
	/**
	* @param libroName the libroName to set
	*/
	public void setlibroName(String libroName) {
		this.libroName = libroName;
	}
	
	//for joing the tables (many-to-many)
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "autor_libro",
	joinColumns = {
	@JoinColumn(name="libroId") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="autorId")
	}
	)
	private Set<Autor> autors;
	
	/**
	* @return the autors
	*/
	public Set<Autor> getautors() {
	return autors;
	}
	
	/**
	* @param autors the autors to set
	*/
	public void setautors(Set<Autor> autors) {
	this.autors = autors;
	}
}