angular.module("expenseApp").factory("authService", function(){
	var logout = false;
	
	return{
		setLogout: function(status){
			logout = status;
		},
		getLogout: function(){
			return logout;
		}
	};
})