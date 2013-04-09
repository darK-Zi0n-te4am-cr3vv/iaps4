<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="main.js" ></script>
         <LINK href="style.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab 1</title>
    </head>
    <body>
        <div class="container">
            <div id="header">
                Буйнов Кирилл, Раевский Сергей 4103 -- Вариант 302
            </div>
            <div id="postform">
            <form action="CheckingServlet" method="Post" onsubmit="return Validate();">
                X: <input type="radio" name="xselect" value="-4" checked>-4
                <input type="radio" name="xselect" value="-3">-3
                <input type="radio" name="xselect" value="-2">-2
                <input type="radio" name="xselect" value="-1">-1
                <input type="radio" name="xselect" value="0">0
                <input type="radio" name="xselect" value="1">1
                <input type="radio" name="xselect" value="2">2
                <input type="radio" name="xselect" value="3">3
                <input type="radio" name="xselect" value="4">4 <br>
                Y: 
                <input type="text" name="yselect"/><br/>
                R: <input type="radio" name="rselect" value="1" checked>1
                <input type="radio" name="rselect" value="2">2
                <input type="radio" name="rselect" value="3">3
                <input type="radio" name="rselect" value="4">4
                <input type="radio" name="rselect" value="5">5<br>
                <input type="submit" value="Отправить" />
            </form>
            </div>
            <div id="resultform">
                Points: <span><%=request.getAttribute("Points")%></span><br/>
                Result: <span><%=request.getAttribute("isHit")%></span><br/>
                Error: <span><%=request.getAttribute("Error")%></span>
            </div>
        </div>
    </body>
</html>
