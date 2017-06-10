/* 
 * The MIT License
 *
 * Copyright 2017 juanm.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ieeeuniandes.backend.dtos;

import com.ieeeuniandes.backend.entities.CategoryEntity;
import com.ieeeuniandes.backend.entities.EventEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanm
 */
public class EventDTO {
    
    
    /**
     * ID del evento
     */
    private Long id;
    
    /**
     * Nombre del evento
     */
    private String nombre;
    
    /**
     * Fecha del evento
     */
    private String fecha;
    
    /**
     * Lugar del evento
     */
    private String lugar;
    
    /**
     * Cupos del evento
     */
    private Integer cupos;
    
    /**
     * Descripción del evento
     */
    private String descripcion;
    
    /**
     * Lista de categorias sobre las cuales esta enmarcado el evento
     */
    private List<CategoryDTO> categorias = new ArrayList<CategoryDTO>();

    public EventDTO() {
    }
    
    public EventDTO(EventEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.nombre = entity.getNombre();
            this.cupos = entity.getCupos();
            this.lugar = entity.getLugar();
            this.fecha = entity.getFecha().toString();
            this.descripcion = entity.getDescripcion();
            this.categorias = list2DTO(entity.getCategorias());
        }
    }
    
    public EventEntity toEntity(){
        EventEntity entity = new EventEntity();
        entity.setId(getId());
        entity.setNombre(getNombre());
        entity.setLugar(getLugar());
        entity.setFecha(Timestamp.valueOf(getFecha()));
        entity.setCupos(getCupos());
        entity.setDescripcion(getDescripcion());
        entity.setCategorias(list2Entity(getCategorias()));
        return entity;
    }
    
    private List<CategoryEntity> list2Entity(List<CategoryDTO> preferencias) {
        List<CategoryEntity> list = new ArrayList<>();
        for(CategoryDTO dto : preferencias){
            list.add(dto.toEntity());
        }
        return list;
    }

    private List<CategoryDTO> list2DTO(List<CategoryEntity> categorias) {
        List<CategoryDTO> list = new ArrayList<>();
        for(CategoryEntity entity : categorias){
            list.add(new CategoryDTO(entity));
        }
        return list;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CategoryDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoryDTO> categorias) {
        this.categorias = categorias;
    }
    
}
