package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Page;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for page table. */
public class PageDao {
  private final Connection connection;

  /** Instantiates a new Page dao. */
  public PageDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Page dao.
   *
   * @param connection the connection
   */
  public PageDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Checks if page exists.
   *
   * @param id id of page
   * @return true if page exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query = connection.prepareStatement("select count(*) from page where id=?");
      query.setObject(1, id);
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return rs.getInt(1) > 0;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return false;
  }

  /**
   * Updates page.
   *
   * @param page updated page
   * @return updated page
   */
  public List<Page> update(Page page) {
    List<Page> pages = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update page set link=?, subject_id=?  where id=?", Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, page.getLink());
      query.setObject(2, page.getSubject());
      query.setObject(3, page.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        pages.add(buildPage(rs));
      }

      query.close();
      connection.commit();

      return pages;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new page.
   *
   * @param page the page
   * @return created page
   */
  public Page add(Page page) {
    try {
      Page newPage = new Page();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into page(link, subject_id) values (?, ?);", Statement.RETURN_GENERATED_KEYS);
      query.setString(1, page.getLink());
      query.setObject(2, page.getSubject());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newPage = buildPage(rs);
      }

      query.close();
      connection.commit();
      return newPage;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all pages.
   *
   * @return list of pages
   */
  public List<Page> getAll() {
    List<Page> pages = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from page");
      while (rs.next()) {
        pages.add(buildPage(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pages;
  }

  /**
   * Gets exact page by id.
   *
   * @param id id of page
   * @return exact page
   */
  public Page getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from page where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildPage(rs);
      } else {
        return null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Gets exact pages by id.
   *
   * @param id id of subject
   * @return exact list of page
   */
  public List<Page> getBySubjectId(String id) {
    List<Page> pages = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from page where subject_id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      while (rs.next()) {
        pages.add(buildPage(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pages;
  }

  /**
   * Delete exact page by id.
   *
   * @param id id of page
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from page where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all pages. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from page");
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Page buildPage(ResultSet rs) throws SQLException {
    return new Page()
        .setId(UUID.fromString(rs.getString("id")))
        .setLink(rs.getString("link"))
        .setSubject((UUID) rs.getObject("subject_id"));
  }
}
