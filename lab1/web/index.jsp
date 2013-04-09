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
                Бевза Роман 4103 <span title="Мне так Жмылев сказал">Вариант 310</span>
            </div>
            <div id="postform">
            <form action="CheckingServlet" method="Post" onsubmit="return Validate();">
                X: <input type="text" name="xselect"/><br/>
                Y: 
                <input type="button" value="-5" onclick="SetY(this);"/>
                <input type="button" value="-4" onclick="SetY(this);"/>
                <input type="button" value="-3" onclick="SetY(this);"/>
                <input type="button" value="-2" onclick="SetY(this);"/>
                <input type="button" value="-1" onclick="SetY(this);"/>
                <input type="button" value="0" onclick="SetY(this);"/>
                <input type="button" value="1" onclick="SetY(this);"/>
                <input type="button" value="2" onclick="SetY(this);"/>
                <input type="button" value="3" onclick="SetY(this);"/>
                <input type="hidden" name="yselect" value="0"/><br/>
                R: 
                1<input type="checkbox" name="rselect" value="1" onchange="SetR(this);" checked="true"/>
                2<input type="checkbox" name="rselect" value="2" onchange="SetR(this);"/>
                3<input type="checkbox" name="rselect" value="3" onchange="SetR(this);"/>
                4<input type="checkbox" name="rselect" value="4" onchange="SetR(this);"/>
                5<input type="checkbox" name="rselect" value="5" onchange="SetR(this);"/><br/>
                <br/>
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
