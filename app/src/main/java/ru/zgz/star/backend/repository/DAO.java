package ru.zgz.star.backend.repository;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.zgz.star.backend.util.HibernateUtil;

import java.util.UUID;

public class DAO<T> {

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
}
