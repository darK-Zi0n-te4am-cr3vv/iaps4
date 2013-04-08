function Validate()
{
    textfields=document.getElementsByName("xselect");
    value=textfields[0].value;    
    var valid = (value.match(/^-?\d+(\.\d+)?$/));
    if( valid)
    {
        if(value>=-5&&value<=5)
            return true;          
    }
    textfields[0].style.borderColor="red";
    return false;    
}

function SetY(sender)
{
    yselect=document.getElementsByName("yselect")[0];
    yselect.value=sender.value;
}

function SetR(sender)
{
    checkboxes=document.getElementsByName("rselect");
    for(itm in checkboxes)
    {
        checkboxes[itm].checked=false;
    }
    sender.checked=true;
}