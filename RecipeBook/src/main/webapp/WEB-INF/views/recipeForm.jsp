<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Recipe</title>
</head>
<body>
    <h2>Create Recipe</h2>
    <form action="/api/recipes/add" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br>

        <label for="categoryId">Category ID:</label>
        <input type="number" id="categoryId" name="categoryId" required><br>

        <label for="userId">User ID:</label>
        <input type="number" id="userId" name="userId" required><br>

        <input type="submit" value="Create Recipe">
    </form>
</body>
</html>
