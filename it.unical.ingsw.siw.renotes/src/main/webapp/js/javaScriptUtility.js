/**
 * 
 */

/**
 * 
 */

function calculateParameters(q,a,c)
{
	var element = document.getElementById("statistics");
	
	var list = [q, a, c];
	for(var i=0; i<list.length; i++)
	{
		element.innerHTML += "<p>";
		for(var j=0; j<list[i]; j++)
			element.innerHTML += "<i class=\"fas fa-star text-warning\"></i>";
		
		for(var k=0; k<5-list[i]; k++)
			element.innerHTML += "<i class=\"fas fa-star text-black-50\"></i>";
		
		element.innerHTML += "</p>"; 	
	}
	
}

function setAdId(id)
{
	//document.setAttribute("adIdByCart", id);
	//$("#adIdByCart").val(id);
	alert(id);
}
