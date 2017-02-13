/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public abstract class AbstractService<T> {

    private Class<T> entityClass;

    //protected abstract EntityManager getEntityManager();
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }   

    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        hibernateTemplate.save(entity);
        //getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        hibernateTemplate.saveOrUpdate(entity);
        //getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        hibernateTemplate.delete(entity);
        //getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        //return hibernateTemplate.find(null) ;
        return null;
        //return getEntityManager().find(entityClass, id);
    }

    public List<Object> findAll() {
        //return hibernateTemplate.find();
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return getEntityManager().createQuery(cq).getResultList();
        return null;
    }

    public List<T> findRange(int[] range) {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        javax.persistence.Query q = getEntityManager().createQuery(cq);
//        q.setMaxResults(range[1] - range[0]);
//        q.setFirstResult(range[0]);
//        return q.getResultList();
        return null;
    }

    public int count() {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
//        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
//        javax.persistence.Query q = getEntityManager().createQuery(cq);
//        return ((Long) q.getSingleResult()).intValue();
        return 0;
    }
}
