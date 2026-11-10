<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Virtual Store - Productos</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #38b6ff; color: white; }
        .btn { padding: 6px 12px; text-decoration: none; background: #38b6ff; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <h1>Virtual Store - Productos</h1>
    <p><a class="btn" href="${pageContext.request.contextPath}/products?action=new">Nuevo producto</a></p>

    <table>
        <tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Stock</th><th>Acciones</th></tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.productId}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td>$<c:out value="${product.price}"/></td>
                <td><c:out value="${product.stock}"/></td>
                <td>
                    <a class="btn" href="${pageContext.request.contextPath}/products?action=edit&id=${product.productId}">Editar</a>
                    <form action="${pageContext.request.contextPath}/products" method="post" style="display:inline"
                          onsubmit="return confirm('¿Eliminar este producto?');">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="productId" value="${product.productId}">
                        <button class="btn" type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty products}">
            <tr><td colspan="5">No hay productos registrados.</td></tr>
        </c:if>
    </table>

    <p>Fecha: <%= java.time.LocalDate.now() %></p>
</body>
</html>