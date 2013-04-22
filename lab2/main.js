function DerKostil()
{
    var img =document.getElementById("img1");
    img.onclick=CheckPoint;
}

function ValidateR()
{
    var checkboxes=document.getElementsByName("rselect");
    for(itm in checkboxes)
    {
        if(checkboxes[itm].checked==true)
            return true;
    }
    return false;
}
function Validate()
{    
    SetParams();
    if(!ValidateR())
    {
        alert("R не задано");
        return false;
    }
    var textfields=document.getElementsByName("yselect");
    var value=textfields[0].value;    
    var valid = (value.match(/^-?\d+(\.\d+)?$/));
    if( valid)
    {
        if(value>=-5&&value<=3)
            return true;          
    }
    alert("Y invalid");
    return false;    
}

function SetParams()
{
    var xs=document.getElementsByName("x");
    for(var itm in xs)
    {
        if(xs[itm].checked)
            document.getElementsByName("xselect")[0].value=xs[itm].value;
    }
    
    document.getElementsByName("yselect")[0].value=document.getElementsByName("y")[0].value;
}

function SetR(sender)
{
    var checkboxes=document.getElementsByName("rselect");
    var checked=sender.checked;
    for(var itm in checkboxes)
    {
        checkboxes[itm].checked=false;
    }
    sender.checked=checked;
}

function CheckPoint(e)
{
    if(!ValidateR())
        {
            alert("R не задано");
            
        return false;
        }
    var sender=document.getElementById("img1")
    var checkboxes=document.getElementsByName("rselect");
    for(itm in checkboxes)
    {
        if(checkboxes[itm].checked==true)
            var r=checkboxes[itm].value;
    }
    
    var mouseEvent = e;
    
    var x;
var y;
if (e.pageX || e.pageY) { 
  x = e.pageX;
  y = e.pageY;
}
else { 
  x = e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft; 
  y = e.clientY + document.body.scrollTop + document.documentElement.scrollTop; 
} 
x -= sender.offsetLeft+409+sender.width/2;
y -= sender.offsetTop+92;
y=sender.height/2-y;
    x=x/80*r;
    y=y/80*r;
    document.getElementsByName("xselect")[0].value=x;
    document.getElementsByName("yselect")[0].value=y;
    document.getElementsByName("subForm")[0].submit();
}
