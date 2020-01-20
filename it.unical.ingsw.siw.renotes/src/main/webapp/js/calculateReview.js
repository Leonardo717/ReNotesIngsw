/**
 * 
 */

function calculate(q,a,c)
{
	var element = document.getElementById("statistics");
	
	var list = [q, a, c];
	for(var i=0; i<list.length; i++)
	{
		for(var j=0; j<list[i]; j++)
			element.innerHTML += "<i class=\"fas fa-star text-warning\"></i>";
		
		for(var k=0; k<5-list[i]; k++)
			element.innerHTML += "<i class=\"fas fa-star text-secondary\"></i>";
		
		element.innerHTML += "<br>"; 	
	}
	
}