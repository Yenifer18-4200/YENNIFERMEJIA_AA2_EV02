package com.virtualstore.servlet;

import com.virtualstore.dao.ProductDAO;
import com.virtualstore.database.DatabaseInitializer;
import com.virtualstore.model.Product;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private final ProductDAO productDAO = new ProductDAO();

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new ServletException("No se encontro el driver de SQLite", e);
        }
        DatabaseInitializer.initialize();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("edit".equals(action)) {
                int productId = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("product", productDAO.findProductById(productId));
                request.getRequestDispatcher("/product-form.jsp").forward(request, response);
            } else if ("new".equals(action)) {
                request.getRequestDispatcher("/product-form.jsp").forward(request, response);
            } else {
                request.setAttribute("products", productDAO.findAllProducts());
                request.getRequestDispatcher("/product-list.jsp").forward(request, response);
            }
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        try {
            if ("save".equals(action)) {
                int productId = Integer.parseInt(request.getParameter("productId"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                int stock = Integer.parseInt(request.getParameter("stock"));
                Product product = new Product(productId, name, price, stock);
                if (productId == 0) {
                    productDAO.insertProduct(product);
                } else {
                    productDAO.updateProduct(product);
                }
            } else if ("delete".equals(action)) {
                productDAO.deleteProduct(Integer.parseInt(request.getParameter("productId")));
            }
            response.sendRedirect(request.getContextPath() + "/products");
        } catch (NumberFormatException e) {
            request.setAttribute("error",
                    "El precio y el stock deben ser números válidos");

            request.setAttribute("product", new Product(
                    0,
                    request.getParameter("name"),
                    0,
                    0
            ));

            request.getRequestDispatcher("/product-form.jsp")
                    .forward(request, response);

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}