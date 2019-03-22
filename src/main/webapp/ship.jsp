<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<%
    if(session.getAttribute("user")==null)
{
    response.sendRedirect("login.jsp");
}
%>
    <form action="FrontController" method="post">
        <h1>Afsend ordre</h1>
        <input class="form-control input" type="text" name="id" required placeholder="Ordrenummer">
        <input class="input btn btn-outline-secondary" type="submit" value="Afsend">
        <input type="hidden" name="command" value="ship">
    <% if (session.getAttribute("result") == "fail") { %>
    <p>Indsæt venligst et positivt heltal!</p>
    <% } else if (session.getAttribute("result") == "success") { %>
    <p>Ordren er blevet afsendt!</p>
    <% } else if (session.getAttribute("result") == "shipped") { %>
    <p>Ordren er allerede blevet sendt</p>
    <% }
        request.getSession().removeAttribute("result");
    %>
</form>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>