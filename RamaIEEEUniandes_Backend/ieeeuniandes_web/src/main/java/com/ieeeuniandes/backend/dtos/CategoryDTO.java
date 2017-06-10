/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieeeuniandes.backend.dtos;

import com.ieeeuniandes.backend.entities.CategoryEntity;

/**
 *
 * @author juanm
 */
public class CategoryDTO {
    
    /**
     * ID de la categoría
     */
    private Long id;
    
    /**
     * Nombre de la categoría
     */
    private String nombre;

    public CategoryDTO() {
    }
    
    public CategoryDTO(CategoryEntity entity){
        if (entity!=null){
            this.id = entity.getId();
            this.nombre = entity.getNombre();
        }
    }
    
    public CategoryEntity toEntity(){
        CategoryEntity entity = new CategoryEntity();
        entity.setId(this.getId());
        entity.setNombre(this.getNombre());
        return entity;
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
