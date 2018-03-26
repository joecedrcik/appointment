package com.leibniz.server.dao.itf;

import com.leibniz.server.repositories.AbstractRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractDao<T extends AbstractRepository> {

    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public final void setDto(Class<T> entityToSet) {
        this.entityClass = entityToSet;
    }

    public T findOne(long id) {
        return entityManager.find(entityClass,id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getName()).getResultList();
    }

    public void create(T entityToCreate){
        entityManager.persist(entityToCreate);
    }

    public void update(T entity){
        entityManager.merge(entity);
    }

    public void delete(T entity){
        entityManager.remove(entity);
    }

    public void deleteById(long idEntity){
        T entityFound = findOne(idEntity);
        delete(entityFound);
    }

}
