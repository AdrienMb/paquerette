function validate()
{
    var a = document.getElementsByClassName("module");
    var valid = false;
    var i;
    for (i = 0; i < a.length; i++) { 
    	 if(a[i].checked){
   		  return true
   	  }
    }
    alert("Sélectionnez au moins un module");
    return false;
};