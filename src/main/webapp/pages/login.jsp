<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
   <head>
       <title>Log in</title>
       <style>
           <%@include file="/css/style.css"%>
       </style>
   </head>

    <body>
        <div class="login-container">
            <form class="form-signin" method="post" action="/login">
                <h1>Вход</h1>
                <input class="form-control" type="text" name="username" placeholder="Логин" autofocus required/>
                <input id="loginPass" class="form-control" type="password" name="password" placeholder="Пароль" required/>
                <button type="submit">Log in</button>
            </form>
        </div>
    </body>

</html>
