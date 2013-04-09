function Validate()
{
    textfields=document.getElementsByName("yselect");
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
