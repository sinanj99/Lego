<%-- 
    Document   : index
    Created on : 14-03-2019, 16:48:05
    Author     : sinanjasar
--%>

<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
    <form action="FrontController" method="post">
        <h1>Log ind</h1>
        <input class="form-control input" type="text" name="username" placeholder="Brugernavn">
        <input class="form-control input" type="password" name="password" placeholder="Adgangskode">
    <% if (session.getAttribute("loginResult") == "noUser") { %>
    <p class="fail">Bruger findes ikke!</p>
    <% } else if (session.getAttribute("loginResult") == "loginFailed") { %>
    <p class="fail">Brugernavn og adgangskode matcher ikke!</p>
    <% } %>
    <input class="input btn btn-outline-secondary" type="submit" value="Log ind">
    <input type="hidden" name="command" value="login">
    <p>Ikke allerede medlem?</p>
    <a class="a" href="register.jsp"> Klik her for at oprette en bruger!</a>
</form>
<%request.getSession().invalidate();
%>


<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>
