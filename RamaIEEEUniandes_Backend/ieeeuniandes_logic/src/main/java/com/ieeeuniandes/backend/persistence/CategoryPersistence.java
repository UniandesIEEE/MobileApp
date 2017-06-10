/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieeeuniandes.backend.persistence;

import com.ieeeuniandes.backend.entities.CategoryEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author juanm
 */
@Stateless
public class CategoryPersistence {
    @PersistenceContext(unitName = "ieeeuniandesPU")
    protected EntityManager em;
    
    public CategoryEntity find(Long id){
        return em.find(CategoryEntity.class, id);
    }
    
    public List<CategoryEntity> findAll(){
        TypedQuery<CategoryEntity> q = em.createQuery("select u from CategoriaEntity u",CategoryEntity.class);
        return q.getResultList();
    }
    
    public CategoryEntity create(CategoryEntity e){
        em.persist(e);
        return e;
    }
    
    public CategoryEntity update(CategoryEntity e){
        return em.merge(e);
    }
    
    public void delete(Long id){
        CategoryEntity e = em.find(CategoryEntity.class, id);
        em.remove(e);
    }
}
