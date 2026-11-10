package com.virtualstore.dao;

import com.virtualstore.database.DatabaseConnection;
import com.virtualstore.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private static final String SQL_INSERT =
            "INSERT INTO Product (name, price, stock) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_ALL =
            "SELECT product_id, name, price, stock FROM Product";
    private static final String SQL_SELECT_BY_ID =
            "SELECT product_id, name, price, stock FROM Product WHERE product_id = ?";
    private static final String SQL_UPDATE =
            "UPDATE Product SET name = ?, price = ?, stock = ? WHERE product_id = ?";
    private static final String SQL_DELETE =
            "DELETE FROM Product WHERE product_id = ?";

    public boolean insertProduct(Product product) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            return statement.executeUpdate() > 0;
        }
    }

    public List<Product> findAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                products.add(mapProduct(result));
            }
        }
        return products;
    }

    public Product findProductById(int productId) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            statement.setInt(1, productId);
            try (ResultSet result = statement.executeQuery()) {
                return result.next() ? mapProduct(result) : null;
            }
        }
    }

    public boolean updateProduct(Product product) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setInt(4, product.getProductId());
            return statement.executeUpdate() > 0;
        }
    }

    public boolean deleteProduct(int productId) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {
            statement.setInt(1, productId);
            return statement.executeUpdate() > 0;
        }
    }

    private Product mapProduct(ResultSet result) throws SQLException {
        return new Product(
                result.getInt("product_id"),
                result.getString("name"),
                result.getDouble("price"),
                result.getInt("stock"));
    }
}
