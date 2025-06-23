package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    @Autowired
    private DataSource dataSource;


    public MySqlCategoryDao(DataSource dataSource){

        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        // get all categories
        List<Category> categories = new ArrayList<>();

        String sql = """
                SELECT *
                FROM categories""";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("category_Id"));
                category.setName(rs.getString("Name"));
                category.setDescription(rs.getString("Description"));

                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(int categoryId)
    {
        // get category by id
        Category category = null;

        String sql1= """
                SELECT category_Id, Name
                FROM categories
                WHERE categoryId = ?""";

       try (Connection conn = dataSource.getConnection();
       PreparedStatement stmt = conn.prepareStatement(sql1)
       ) {
           stmt.setInt(1, categoryId);

           ResultSet rs = stmt.executeQuery();

           if (rs.next()) {
               int id = rs.getInt("category_Id");
               String name = rs.getString("Name");

               category = new Category();
               category.setCategoryId(id);
               category.setName(name);
           }

       } catch (SQLException e) {
           e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category create(Category category)
    {
        // create a new category
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());

        String sql2 = """
                INSERT INTO categories (name, description)
                VALUES (?,?)""";

        try (Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql2)
        ) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCategory;
    }

    @Override
    public void update(int categoryId, Category category)
    {
        // update category
        String sql = """
            UPDATE categories
            SET name = ?, description = ?
            WHERE categoryId = ?
            """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getCategoryId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryId)
    {
        // delete category
        String sql = """
            DELETE FROM categories
            WHERE categoryId = ?
            """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, categoryId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
