/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieeeuniandes.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author juanm
 */
@Entity
public class CategoriaEntity {
    
    /**
     * ID de la categoría
     */
    @Id
    @GeneratedValue
    private Long id;
    
    /**
     * Nombre de la categoría
     */
    private String nombre;

    public CategoriaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
