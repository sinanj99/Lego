<%-- 
    Document   : shop
    Created on : 18-03-2019, 12:40:49
    Author     : sinanjasar
--%>

<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<%
    if(session.getAttribute("user")==null)
{
    response.sendRedirect("login.jsp");
}
%>

<form action="FrontController" method="post">
    <h1>Indtast dimensioner</h1>
    <input class="input form-control" type="text" name="height" required placeholder="Højde (antal klodser)">
    <input class="input form-control" type="text" name="length" required placeholder="Længde (antal prikker)">
    <input class="input form-control" type="text" name="width" required placeholder="Bredde (antal prikker)">
    <%if(session.getAttribute("result") == "fail") { %>
    <p>Indsæt venligst positive heltal</p>
    <% } %>
    <input class="input btn btn-outline-secondary" type="submit" value="Bestil">
    <input type="hidden" name="command" value="shop">
</form>
<%
    session.removeAttribute("result");
%>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>