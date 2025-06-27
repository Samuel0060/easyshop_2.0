//package org.yearup.data.mysql;
//
//
//import org.springframework.stereotype.Component;
//import org.yearup.data.ShoppingCartDao;
//import org.yearup.models.Product;
//import org.yearup.models.ShoppingCart;
//import org.yearup.models.ShoppingCartItem;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Component
//public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {
//
//    public MySqlShoppingCartDao(DataSource dataSource) {
//        super(dataSource);
//    }
//
////    @Override
////    public ShoppingCart getByUserId(int userId) {
////        String sql = """
////                SELECT SELECT shopping_cart.product_id, shopping_cart.quantity, products*, shopping_cart.quantity " +
////                                       "FROM shopping_cart " +
////                                       "JOIN products ON shopping_cart.product_id = products.products_id
////                                       "WHERE sc.user_id = ?""";
////
////        try (Connection connection = getConnection();
////             PreparedStatement statement = connection.prepareStatement(sql))
////        {
////            statement.setInt(1, userId);
////
////            ResultSet row = statement.executeQuery();
////
////            while (row.next())
////            {
////                Product product = mapProduct(row);
////                int quantity = row.getInt("quantity");
////
////                ShoppingCartItem item = new ShoppingCartItem();
////                item.setProduct(product);
////                item.setQuantity(quantity);
////
////                cart.add(item);
////            }
////        }
////        catch (SQLException e)
////        {
////            throw new RuntimeException("Error loading shopping cart", e);
////        }
////
////        return cart;
////        return null;
////    }
//
//    @Override
//    public void addItemToCart(int productId, int userId) {
//
//    }
//
//    @Override
//    public void updateItemQuantity(int userId, int productId, int quantity) {
//
//    }
//
//    @Override
//    public void deleteAllItem(int productId) {
//
//    }
//}
