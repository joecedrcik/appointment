package com.leibniz.server.dao.itf;

import com.leibniz.server.repositories.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
@Repository
//@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public abstract class AbstractDao<T extends AbstractRepository>
        implements IGenericDao<Serializable> {

    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public final void setEntity(Class<T> entityToSet) {
        this.entityClass = entityToSet;
    }

    public AbstractDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
//    public AbstractDao() {
//        Type t = getClass().getGenericSuperclass();
//        ParameterizedType pt = (ParameterizedType) t;
//        entityClass = (Class) pt.getActualTypeArguments()[0];
//    }

    public Serializable findOne(long id) {
        return entityManager.find(entityClass, id);
    }

    public List<Serializable> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getName()).getResultList();
    }

    public void create(Serializable entityToCreate) {
        entityManager.persist(entityToCreate);
    }

    public void update(Serializable entity) {
        entityManager.merge(entity);
    }

    public void delete(Serializable entity) {
        entityManager.remove(entity);
    }

    public void deleteById(long idEntity) {
        Serializable entityFound = findOne(idEntity);
        delete(entityFound);
    }

}
