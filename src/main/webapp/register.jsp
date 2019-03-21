<%-- 
    Document   : register
    Created on : 14-03-2019, 20:06:52
    Author     : sinanjasar
--%>

<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>

<script type="text/javascript">
    
    function validate() {
        var username = document.getElementById("uname").value;
        var password = document.getElementById("pword").value;
        var regxUname = /^[a-z0-9_-]{3,15}$/;
        var regxPword = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$/;
        if (!regxUname.test(username)) {
            username.style.border = "solid 2px red";
            document.getElementById("lblUname").style.visibility = "visible";
            alert("Username invalid!");
            return false;
        } else if (!regxPword.test(password)) {
            username.style.border = "solid 2px red";
            document.getElementById("lblPword").style.visibility = "visible";
            alert("Password invalid!");
            return false;
        } else {
            return true;
        }
    }
</script>

<form onsubmit="return validate();" action="FrontController" method="post">
    <h1>Registrer</h1>
    <%System.out.println(session.getAttribute("registerResult"));%>
<%if(session.getAttribute("registerResult") == "duplicate") { %>
    <input class="form-control input inputfail" type="text" id="uname" name="username" placeholder="Brugernavn optaget!">
    <% } else if(session.getAttribute("registerResult") == "invalidUsername"){ %>
    <input class="form-control input" type="text" id="uname" name="username" required placeholder="Ugyldigt brugernavn">
    <% } else { %>
    <input class="form-control input" type="text" id="uname" name="username" required placeholder="Brugernavn">
  <!--  <label id="lblUname" class="input" style="color: red; visibility: hidden;">Invalid</label> -->
    <% } 
    if(session.getAttribute("registerResult") == "invalidPassword") { %>
    <input class="form-control input" type="password" id="pword" name="password" required placeholder="Ugyldig adgangskode">
   <!-- <label id="lblPword" class="input" style="color: red; visibility: hidden;">Invalid</label> -->
   <% } else { %>
   <input class="form-control input" type="password" id="pword" name="password" required placeholder="Adgangskode">
   <% } %>
    <button class="input btn btn-outline-secondary" type="submit">Registrer</button>
    <input type="hidden" name="command" value="register">
    <p>Allerede medlem?</p>
    <a class="a" href="login.jsp"> Klik her for at logge ind!</a>
</form>

<%request.getSession().removeAttribute("registerResult");
%>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>
