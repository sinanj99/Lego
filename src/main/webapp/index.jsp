<%-- 
    Document   : index
    Created on : 18-03-2019, 12:32:04
    Author     : sinanjasar
--%>

<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<%if(session.getAttribute("user")==null)
{
    response.sendRedirect("login.jsp");
}%>
<form action="shop.jsp" method="get">
    <h1>
        Hvad venter du på? Bestil et legohus nu!
    </h1>
    <input class="input btn btn-outline-secondary" type="submit" value="Shop">
</form>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>
