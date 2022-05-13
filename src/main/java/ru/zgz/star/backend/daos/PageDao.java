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
   * Create new page.
   *
   * @param page the page
   */
  public void add(Page page) {
    try {
      PreparedStatement query = connection.prepareStatement("insert into page(link) values (?);");
      query.setString(1, page.getLink());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all page.
   *
   * @return list of page
   */
  public List<Page> getAll() {
    List<Page> pages = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from page");
      while (rs.next()) {
        pages.add(
            new Page().setId(UUID.fromString(rs.getString("id"))).setLink(rs.getString("link")));
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
      return buildPage(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
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

  /** Delete all accounts. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from page");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Page buildPage(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Page().setId(UUID.fromString(rs.getString("id"))).setLink(rs.getString("link"));
    } else {
      return null;
    }
  }
}
