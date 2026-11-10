
package com.virtualstore;

import com.virtualstore.dao.ProductDAO;
import com.virtualstore.model.Product;
import java.sql.SQLException;
import java.util.List;

public class CrudDemo {

    public static void run() {
        ProductDAO productDAO = new ProductDAO();

        try {
            System.out.println("=== 1. INSERTAR ===");

            Product testProduct = new Product(
                    0, "Producto de prueba", 25000.0, 10
            );

            System.out.println(productDAO.insertProduct(testProduct)
                    ? "Producto registrado"
                    : "No se pudo registrar");

            System.out.println("\n=== 2. CONSULTAR TODOS ===");

            List<Product> products = productDAO.findAllProducts();
            products.forEach(System.out::println);

            if (!products.isEmpty()) {

                // El producto recién insertado es el último de la lista.
                Product lastProduct = products.get(products.size() - 1);
                int productId = lastProduct.getProductId();

                System.out.println("\n=== 3. BUSCAR POR ID (" + productId + ") ===");
                System.out.println(productDAO.findProductById(productId));

                System.out.println("\n=== 4. ACTUALIZAR ===");

                lastProduct.setPrice(30000.0);
                lastProduct.setStock(20);

                System.out.println(productDAO.updateProduct(lastProduct)
                        ? "Producto actualizado"
                        : "No se pudo actualizar");

                System.out.println(productDAO.findProductById(productId));

                System.out.println("\n=== 5. ELIMINAR ===");

                System.out.println(productDAO.deleteProduct(productId)
                        ? "Producto eliminado"
                        : "No se pudo eliminar");

                System.out.println("Producto después de eliminar: "
                        + productDAO.findProductById(productId));

            } else {
                System.out.println("No hay productos para realizar las pruebas.");
            }

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }
}

