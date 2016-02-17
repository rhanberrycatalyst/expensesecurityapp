angular.module("expenseApp").factory("authService", function(){
	var logout = false;
	
	//service to set the user as logged out
	return{
		setLogout: function(status){
			logout = status;
		},
		getLogout: function(){
			return logout;
		}
	};
})