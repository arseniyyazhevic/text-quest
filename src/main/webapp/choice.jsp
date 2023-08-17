<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.08.2023
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="application.css">
    <title>Game</title>
    <style>
        body {
            background: #1a1a1a; /* Цвет фона */
            color: #ffffff; /* Цвет текста */
        }

    </style>
</head>
<body>
<img src="${image}"/>
<p>
    ${text}
    <button>
        <a href="http://localhost:8081/play?id=true">Да</a>
    </button>
        <button>
            <a href="http://localhost:8081/play?id=false">Нет</a>
        </button>
</p>
</body>
</html>
