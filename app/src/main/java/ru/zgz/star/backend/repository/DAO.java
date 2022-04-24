package ru.zgz.star.backend.repository;

import com.google.common.base.CaseFormat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.routes.AccountRouter;
import ru.zgz.star.backend.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.UUID;

public class DAO<T> {

  public static Logger logger = LoggerFactory.getLogger(AccountRouter.class);
  private final Class<T> type;

  public DAO(Class<T> tClass) {
    this.type = tClass;
  }

  static EntityManager getEntityManager() {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    return sf.createEntityManager();
  }

  static void closeConnection(EntityManager em) {
    em.getTransaction().commit();
    em.close();
  }

  public List<T> findAll() {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(type);
    Root<T> root = cq.from(type);
    cq.select(root);
    List<T> result = em.createQuery(cq).getResultList();
    closeConnection(em);
    return result;

  }

  public T findById(UUID id) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    T result = em.find(type, id);
    closeConnection(em);
    return result;
  }

  public T findById(String id) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    T result = em.find(type, UUID.fromString(id));
    closeConnection(em);
    return result;
  }

  public void save(T model) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    em.persist(model);
    closeConnection(em);
  }

  public void delete(UUID id) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    T model = findById(id);
    em.remove(model);
    closeConnection(em);
  }

  public void delete(String id) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    T model = findById(id);
    em.remove(model);
    closeConnection(em);
  }

  public void update(T model) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    em.merge(model);
    em.getTransaction().commit();
  }
}
