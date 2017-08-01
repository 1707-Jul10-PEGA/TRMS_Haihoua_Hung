function newWindow()
{
	window.open('form.html');
}

function closeWindow()
{
	window.close();
}

function viewInfo()
{
	window.open('http://localhost:8020/TRMS/ViewRequest');
}
function handleEvent(){
	
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET", "ViewRequest", true);
	
	xhr.send();
}

window.onload = function(){
	
	document.getElementById("myBtn").addEventListener("click", handleEvent, false);
}