<%@page contentType="text/html" pageEncoding="UTF-8"
        import="classes.Checking"%>

<%
    String points="";
    String error="";
    boolean isHit=false;

        try{
            points=request.getParameter("xselect")+";"+request.getParameter("yselect")+";"+request.getParameter("rselect");
            
            double x = Double.parseDouble(request.getParameter("xselect"));
            double y= Double.parseDouble(request.getParameter("yselect"));
            double r= Double.parseDouble(request.getParameter("rselect"));
            Checking.CheckThrow(r, x, y);
            isHit=Checking.LastState;
        }
        catch(Exception ex)
        {
            error=ex.toString();
        }
%>
<!DOCTYPE html>
<html>
    <head>
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="main.js" ></script>
         <LINK href="style.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab 2</title>
    </head>
    <body>
        <div class="container">
            <div id="header">
                Буйнов Кирилл, Раевский Сергей 4103 Вариант 323
            </div>
            <div id="postform">
                <form name="subForm" method="Post" onsubmit="return lab2.preSendForm()">
                <table>
                    <tr>
                        <td>
                        X:  -3<input type="radio" name="x" value="-3"/>
                            -2<input type="radio" name="x" value="-2"/>
                            -1<input type="radio" name="x" value="-1"/>
                            0<input type="radio" name="x" value="0"/>
                            1<input type="radio" name="x" value="1" checked="true"/>
                            2<input type="radio" name="x" value="2"/>
                            3<input type="radio" name="x" value="3" />
                            4<input type="radio" name="x" value="4"/>
                            5<input type="radio" name="x" value="5" />
                           <br/><br/>
                           <input type="hidden" name="xselect" value="0">
                        Y: 
                        <input type="text" name="y"/><br/><br/>
                        <input type="hidden" name="yselect" value="0">
                        R: 
                        1<input type="radio" name="r" value="1" onchange="SetR(this);" checked="true"/>
                        2<input type="radio" name="r" value="2" onchange="SetR(this);"/>
                        3<input type="radio" name="r" value="3" onchange="SetR(this);"/>
                        4<input type="radio" name="r" value="4" onchange="SetR(this);"/>
                        5<input type="radio" name="r" value="5" onchange="SetR(this);"/><br/>
						<input type="hidden" name="rselect" value="0">
                        <br/>
                        </td>
                        <td>
                            <img id="img1" src="areas.png">
                        </td>
                    </tr></table>
                <input type="submit" value="Отправить" />
                
            </form>
            </div>
            <div id="resultform">
                Points: <span><%=points%></span><br/>
                Result: <span><%=isHit%></span><br/>
                Error: <span><%=error%></span>
            </div>
        </div>
    </body>
</html>
