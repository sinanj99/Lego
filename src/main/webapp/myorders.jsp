<%@page import="Data.User"%>
<%@page import="java.util.List"%>
<%@page import="Logic.ShopController"%>
<%@page import="Data.Order"%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<% User user = (User) request.getSession().getAttribute("user"); %>
<% List<Order> orders = (List) request.getSession().getAttribute("orders"); %>
<%
    if(session.getAttribute("user")==null)
{
    response.sendRedirect("login.jsp");
} 
%>
<div class="div">
<form>
    <%
        if (session.getAttribute("result") == "noorders") {
    %>
    <h1>Du har ingen ordrer!</h1>
    <% } else { %>
    
    <ul> 
        <% for (Order o : orders) { %>
        <% if (o.getShipped() == null) {%>
        <li> <a class="a" href="/LegoProject/FrontController?command=showorder&id=<%=o.getOrder_id()%>"> Ordrenr: <%= o.getOrder_id()%> - Endnu ikke afsendt!</a></li>    
            <% } else {%>
        <li> <a class="a" href="/LegoProject/FrontController?command=showorder&id=<%=o.getOrder_id()%>"> Ordrenr: <%= o.getOrder_id()%> - Tidspunkt for afsendelse: <%= o.getShipped()%></a></li>    
        <% }
    } %>
    </ul>
    <% }%>
</form>
</div>

<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>