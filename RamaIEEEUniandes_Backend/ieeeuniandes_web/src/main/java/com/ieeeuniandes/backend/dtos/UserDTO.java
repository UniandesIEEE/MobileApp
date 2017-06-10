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
import com.ieeeuniandes.backend.entities.UserEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanm
 */
public class UserDTO implements Serializable{
    /**
     * ID de usuario
     */
    private Long id;
    
    /**
     * Nombre de usuario
     */
    private String nombre;
    
    /**
     * Login de usuario
     */
    private String login;
    
    /**
     * Puntaje de usuario
     */
    private Integer puntaje;
    
    /**
     * Categorías de preferencia
     */
    private List<CategoryDTO> preferencias;

    public UserDTO() {
    }
    
    public UserDTO(UserEntity entity) {
        if(entity!=null){
            this.id = entity.getId();
            this.login = entity.getLogin();
            this.nombre = entity.getNombre();
            this.puntaje = entity.getPuntaje();
            this.preferencias = list2DTO(entity.getPreferencias());
        }
    }

    public UserEntity toEntity(){
        UserEntity entity = new UserEntity();
        entity.setId(getId());
        entity.setLogin(getLogin());
        entity.setNombre(getNombre());
        entity.setPuntaje(getPuntaje());
        entity.setPreferencias(list2Entity(getPreferencias()));
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public List<CategoryDTO> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(List<CategoryDTO> preferencias) {
        this.preferencias = preferencias;
    }
    
}
