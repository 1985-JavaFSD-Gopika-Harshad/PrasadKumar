<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Recipe List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .nav {
            text-align: center;
            margin: 20px 0;
        }
        .nav a {
            text-decoration: none;
            padding: 10px 20px;
            background: #007bff;
            color: white;
            border-radius: 5px;
        }
        .nav a:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Recipe List</h1>

        <div class="nav">
            <a href="${pageContext.request.contextPath}/">Back to Home</a>
        </div>

        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Category Name</th>
                <th>Username</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="recipe" items="${recipes}">
                <tr>
                    <td>${recipe.id}</td>
                    <td>${recipe.title}</td>
                    <td>${recipe.description}</td>
                    <td>${recipe.categoryName}</td>
                    <td>${recipe.username}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/recipes/${recipe.id}" method="post" style="display:inline;">
                            <input type="hidden" name="_method" value="delete"/>
                            <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this recipe?');"/>
                        </form>
                        <a href="${pageContext.request.contextPath}/recipes/${recipe.id}/edit">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Recipe List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .nav {
            text-align: center;
            margin: 20px 0;
        }
        .nav a {
            text-decoration: none;
            padding: 10px 20px;
            background: #007bff;
            color: white;
            border-radius: 5px;
        }
        .nav a:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Recipe List</h1>

        <div class="nav">
            <a href="${pageContext.request.contextPath}/">Back to Home</a>
        </div>

        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Category Name</th>
                <th>Username</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="recipe" items="${recipes}">
                <tr>
                    <td>${recipe.id}</td>
                    <td>${recipe.title}</td>
                    <td>${recipe.description}</td>
                    <td>${recipe.categoryName}</td>
                    <td>${recipe.username}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/recipes/${recipe.id}" method="post" style="display:inline;">
                            <input type="hidden" name="_method" value="delete"/>
                            <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this recipe?');"/>
                        </form>
                        <a href="${pageContext.request.contextPath}/recipes/${recipe.id}/edit">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
