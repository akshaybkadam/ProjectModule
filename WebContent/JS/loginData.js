function loginEmployee(){
	alert("InSide");
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	var eDetails = 
	{
		'username': username,
		'password' : password	
	}
 
	$.ajax({
	    url: 'loginServlet',
	    type: 'POST',
	    dataType: 'text',
	    data: eDetails,
	    success: function (data) {
	     alert("done it");
	    },
	    error: function(data){
	    	//alert(JSON.stringify(data));
	    	alert("error");
	    }
	});
	alert("Done");
}

function saveEmployee(){
	
	var uname = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var country = document.getElementById("country").value;
	
	alert(country);  
	
	var eDetails = 
		{
			'uname': uname,
			'email' : email,
			'password' : password,
			'country' :country
		}
	 
	$.ajax({
        url: 'saveServlet',
        type: 'POST',
        dataType: 'text',
        data: eDetails,
        success: function (data) {
         alert(data);
         window.location = "http://localhost:8082/Dems/index.html";
        },
        error: function(data){
        	//alert(JSON.stringify(data));
        	alert("error");
        }
        
    });	
}