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
package com.ieeeuniandes.backend.persistence;

import com.ieeeuniandes.backend.entities.CategoryEntity;
import com.ieeeuniandes.backend.entities.EventEntity;
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
public class EventPersistence {
    @PersistenceContext(unitName = "ieeeuniandesPU")
    protected EntityManager em;
    
    public EventEntity find(Long id){
        return em.find(EventEntity.class, id);
    }
    
    public List<EventEntity> findAll(){
        TypedQuery<EventEntity> q = em.createQuery(
        "select u from EventEntity u",EventEntity.class);
        return q.getResultList();
    }
    
    public EventEntity create(EventEntity e){
        em.persist(e);
        return e;
    }
    
    public EventEntity update(EventEntity e){
        return em.merge(e);
    }
    
    public void delete(Long id){
        EventEntity e = em.find(EventEntity.class, id);
        em.remove(e);
    }
}
