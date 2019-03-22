<%@page import="Data.Order"%>
<%@page import="Data.House"%>
<%@page import="Data.Bricks"%>
<%@page import="Logic.ShopController"%>

<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<%
    if(session.getAttribute("user")==null)
{
    response.sendRedirect("login.jsp");
}
    Bricks bricks = (Bricks) session.getAttribute("bricks");
    Order order = (Order) session.getAttribute("order");
    int allFours = bricks.getFour();
    int foursPerLayer = bricks.getFour() / order.getHeight();
    int foursPerSideL = bricks.getFourSideL();
    int foursPerSideW = (int) bricks.getFourSideW();
    int allTwos = bricks.getTwo();
    int twosPerLayer = bricks.getTwo() / order.getHeight();
    int twosPerSideL = bricks.getTwoSideL();
    int twosPerSideW = bricks.getTwoSideW();
    int allOnes = bricks.getOne();
    int onesPerLayer = bricks.getOne() / order.getHeight();
    int onesPerSideL = bricks.getOneSideL();
    int onesPerSideW = bricks.getOneSideW();

%>

<form>
    <h1>Stykliste for ordre</h1>
    <div class="tablediv">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Type</th>
                    <th>side 1</th>
                    <th>side 2</th>
                    <th>side 3</th>
                    <th>side 4</th>
                    <th>i alt</th>
                    <th>x højde</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>2x4</td>
                    <td><%= foursPerSideL%></td>
                    <td><%= foursPerSideW%></td>
                    <td><%= foursPerSideL%></td>
                    <td><%= foursPerSideW%></td>
                    <td><%= foursPerLayer%></td>
                    <td><%= allFours%></td>
                </tr>
                <tr>
                    <td>2x2</td>
                    <td><%= twosPerSideL%></td>
                    <td><%= twosPerSideW%></td>
                    <td><%= twosPerSideL%></td>
                    <td><%= twosPerSideW%></td>
                    <td><%= twosPerLayer%></td>
                    <td><%= allTwos%></td>
                </tr>
                <tr>
                    <td>1x2</td>
                    <td><%= onesPerSideL%></td>
                    <td><%= onesPerSideW%></td>
                    <td><%= onesPerSideL%></td>
                    <td><%= onesPerSideW%></td>
                    <td><%= onesPerLayer%></td>
                    <td><%= allOnes%></td>
                </tr>
            </tbody>
        </table>
    </div>
</form>
<% session.removeAttribute("bricks"); %>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>