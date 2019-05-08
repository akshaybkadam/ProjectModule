function saveEmployee(){
	/**
	 * trying to get all values by the form id*/
	
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
        url: 'http://localhost:8082/Dems/saveServlet',
        type: 'POST',
        dataType: 'text',
        data: eDetails,
        success: function (data) {
         alert(data);
        },
        error: function(data){
        	//alert(JSON.stringify(data));
        	alert("error");
        }
        
    });
	
	
	
	
	
}