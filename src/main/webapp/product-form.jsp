<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Virtual Store - Formulario de producto</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        label { display: block; margin-top: 12px; }
        input { padding: 6px; width: 300px; }
        .btn { padding: 8px 14px; background: #38b6ff; color: white; border: none; text-decoration: none; cursor: pointer; }
        .error { color: #c00; }
    </style>
</head>
<body>
    <h1><c:choose>
        <c:when test="${product != null}">Editar producto</c:when>
        <c:otherwise>Nuevo producto</c:otherwise>
    </c:choose></h1>

    <c:if test="${not empty error}"><p class="error">${error}</p></c:if>

    <form action="${pageContext.request.contextPath}/products" method="post">
        <input type="hidden" name="action" value="save">
        <input type="hidden" name="productId" value="${product != null ? product.productId : 0}">

        <label>Nombre</label>
        <input type="text" name="name" value="${product.name}" required>

        <label>Precio</label>
        <input type="number" name="price" step="0.01" min="0" value="${product.price}" required>

        <label>Stock</label>
        <input type="number" name="stock" min="0" value="${product.stock}" required>

        <p>
            <button class="btn" type="submit">Guardar</button>
            <a class="btn" href="${pageContext.request.contextPath}/products">Cancelar</a>
        </p>
    </form>
</body>
</html>