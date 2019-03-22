<%@page import="Data.User"%>
<%@page import="java.util.List"%>
<%@page import="Logic.ShopController"%>
<%@page import="Data.Order"%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<% User user = (User) request.getSession().getAttribute("user");
    List<Order> orders = (List) request.getSession().getAttribute("orders");
    String result = (String) session.getAttribute("result");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<div class="div">
    <form>
        <% if (result == "noorders") { %>
        <h1>Ingen ordrer at se!</h1>
        <% } else { %>
        <ul> 
            <% for (Order o : orders) { %>
            <% if (o.getShipped() == null) {%>
            <li> <a class="a" href="/LegoProject/FrontController?command=showorder&id=<%=o.getOrder_id()%>"> Ordrenr: <%= o.getOrder_id()%> - Endnu ikke afsendt!</a></li>    
                <% } else {%>
            <li> <a class="a" href="/LegoProject/FrontController?command=showorder&id=<%=o.getOrder_id()%>"> Ordrenr: <%= o.getOrder_id()%> - Afsendt: <%= o.getShipped()%></a></li>    
                <% }
                        }
                    }%>
        </ul>
    </form>
</div>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>