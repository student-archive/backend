package ru.zgz.star.backend.repository;

import com.google.common.base.CaseFormat;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.zgz.star.backend.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

/**
 * Data access object
 *
 * @param <T> Model of database
 */
public class DAO<T> {

  private final Class<T> type;

  /**
   * Constructor for DAO
   *
   * @param tClass class instance
   * <p>
   * Usage:
   * <pre>
   * {@code DAO<Account> = new DAO<>(Account.class);}
   *
   */
  public DAO(Class<T> tClass) {
    this.type = tClass;
  }

  private static EntityManager getEntityManager() {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    return sf.createEntityManager();
  }

  private static void closeConnection(EntityManager em) {
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Finds all entities in database
   *
   * @return list of model's objects
   */
  public List<T> findAll() {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    String table_name = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "SomeInput");
    return em.createQuery(String.format("select %s from %s", table_name, table_name), type)
        .getResultList();
  }

  /**
   * Finds one entity by its ID
   *
   * @param id ID of row in database
   * @return One entity
   */
  public T findById(UUID id) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    T result = em.find(type, id);
    closeConnection(em);
    return result;
  }

  /**
   * Finds one entity by its ID
   *
   * @param id ID of row in database
   * @return One entity
   */
  public T findById(String id) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    T result = em.find(type, UUID.fromString(id));
    closeConnection(em);
    return result;
  }

  /**
   * Creates new row in database
   *
   * @param model Model instance
   */
  public void save(T model) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    em.persist(model);
    closeConnection(em);
  }

  /**
   * Deletes one entity by its ID
   *
   * @param id ID of row in database
   */
  public void delete(UUID id) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    T model = findById(id);
    em.remove(model);
    closeConnection(em);
  }

  /**
   * Deletes one entity by its ID
   *
   * @param id ID of row in database
   */
  public void delete(String id) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    T model = findById(id);
    em.remove(model);
    closeConnection(em);
  }

  /**
   * Updates entity
   *
   * @param model Edited entity
   */
  public void update(T model) {
    EntityManager em = getEntityManager();
    em.getTransaction().begin();
    em.merge(model);
    em.getTransaction().commit();
  }
}
