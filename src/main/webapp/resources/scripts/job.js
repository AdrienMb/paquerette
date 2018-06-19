function validate()
{
    var a = document.getElementsByClassName("job");
    var valid = false;
    var i;
    for (i = 0; i < a.length; i++) { 
    	 if(a[i].checked){
   		  return true
   	  }
    }
    alert("Sélectionnez au moins un métier");
    return false;
};

function hideJob(){
	var c = document.getElementById("jobForm").getElementsByTagName('input');
	arr = []
	// loop on all checkboxes to see which domaines are checked
    for (var i = 0; i < c.length; i++) {
        if (c[i].type == 'checkbox') {
            if (c[i].checked) {
            	arr.push(parseInt(c[i].value));
            }
        }
    }
	var selected = false;
	// loop on all jobs to hide the ones which do not belong to the domaines chosen
	var jobs = $(".job");
	jobs.get().forEach(function(opt, i, jobs) {
	//for (var i = 0; i < $('.job').length; i++) {
		//var opt = document.getElementById('jobSelect').options[i];
		if (arr.length > 0) {
			// check if domaines checked are in job's domaines
			if (arr.filter(function(n) {return job_domaines.get(opt.value).indexOf(n) !== -1;}).length > 0) {
				opt.style.display = "initial";
				$("."+opt.value)[0].style.display = "initial";
			} else {
				opt.style.display = "none";
				console.log($("."+opt.value));
				$("."+opt.value)[0].style.display = "none";
			}
		} else {
			// if no checkboxe is checked, display all jobs
			opt.style.display = "initial";
			$("."+opt.value)[0].style.display = "initial";
		}
	})
}





function hideJob2(){
	var domaine=document.getElementsByClassName("domaine");
	var job=document.getElementsByClassName("job");
	var selectedDomaine = [];
	
	
	
	for ( var i = 0; i < domaine.length; i++) { 
   	 if(domaine[i].checked){
   		selectedDomaine.push(domaine[i]);
  	  }
   }
	jobs.get().forEach(function(opt, i, jobs) {
		if (selectedDomaine.length > 0) {
			// check if domaines checked are in job's domaines
			if (selectedDomaine.filter(function(n) {return job_domaines.get(opt.value).indexOf(n) !== -1;}).length > 0) {
				opt.style.display = "initial";
				$("."+opt.value)[0].style.display = "initial";
			} 
			else {
				opt.style.display = "none";
				console.log($("."+opt.value));
				$("."+opt.value)[0].style.display = "none";
			}
		}
		else {
			// if no checkboxe is checked, display all jobs
			opt.style.display = "initial";
			$("."+opt.value)[0].style.display = "initial";
		}
	})
}



