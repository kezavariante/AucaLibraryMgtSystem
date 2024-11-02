<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Sign In page</title>
</head>
<body>
    <div class="login-box">
        <div class="login-header">
            <header>Sign In</header>
        </div>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
        <% if (request.getAttribute("successMessage") != null) { %>
            <p style="color:green;"><%= request.getAttribute("successMessage") %></p>
        <% } %>
        <form class="signin" action="login" method="post">
            <div class="input-box">
                <input 
                    type="text" 
                    class="input-field"
                    placeholder="Username" 
                    name="userName" 
                    autocomplete="off" 
                    required
                >
            </div>
            <div class="input-box">
                <input 
                    type="password" 
                    class="input-field" 
                    placeholder="Password" 
                    name="password" 
                    autocomplete="off" 
                    required
                >
            </div>
            <div class="forgot">
                <section>
                    <input type="checkbox" id="check" name="rememberMe">
                    <label for="check">Remember me</label>
                </section>
                <section>
                    <a href="#">Forgot password?</a>
                </section>
            </div>
            <div class="input-submit">
                <button class="submit-btn" type="submit">Sign In</button>
            </div>
        </form>
        <!-- End of Form -->
        <div class="sign-up-link">
            <p>Don't have an account? <a href="signup.html">Sign Up</a></p>
        </div>
    </div>
</body>
</html>
