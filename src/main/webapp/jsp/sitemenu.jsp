<%-- 
    Document   : sitemenu
    Created on : 14-03-2019, 16:49:40
    Author     : sinanjasar
--%>

<%@page import="java.util.List"%>
<%@page import="Data.Order"%>
<%@page import="Data.ShoppingCart"%>
<%@page import="Data.User"%>
<% User user = (User) session.getAttribute("user"); 
List<Order> cart = (List) session.getAttribute("cart"); 
int amount = 0;
if(cart != null)
{
 amount = cart.size(); 
}%>

<div id="nav">

        <% if (user != null && user.getIsAdmin() == 1) {
        %>

        <a class="left" href="/LegoProject/index.jsp">Forside <i class="fas fa-toilet-paper"></i></a>
        <a class="right" href="/LegoProject/FrontController?command=logout">Log ud <i class="fas fa-sign-out-alt"></i></a>
        <a class="right" href="/LegoProject/FrontController?command=orders">Alle ordrer <i class="fas fa-list-ul"></i></a>
        <a class="right" href="/LegoProject/ship.jsp">Afsend ordre <i class="fas fa-shipping-fast"></i></a>
        

        <%
        } else if (user != null) {
        %>
        <a class="left" href="/LegoProject/index.jsp">Forside <i class="fas fa-toilet-paper"></i></a>
        <a class="right" href="/LegoProject/FrontController?command=logout">Log ud <i class="fas fa-sign-out-alt"></i></a>
        <a class="right" href="/LegoProject/FrontController?command=myorders">Mine ordrer <i class="fas fa-list-ul"></i></a>
        <a class="right" href="/LegoProject/shop.jsp">Shop <i class="fas fa-shopping-bag"></i></a>
        <%
            if(cart != null)
        %>
        <a class="right" href="/LegoProject/index.jsp">Indkøbskurv <%= amount%> <i class="fas fa-shopping-basket"></i></a>
        <p>Hej <%= user.getUsername()%>!</p>
        <%
        } else {
        %>
        <a class="left" href="#">Kontakt</a>
        <a class="left" href="#">Hjælp</a>
        <a class="right" href="#">Om os</a>
        <%
            }
        %>
    </div>
