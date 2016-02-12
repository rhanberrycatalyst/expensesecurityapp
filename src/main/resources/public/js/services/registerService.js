angular.module("expenseApp").factory("authService", function(){
	var register = false;
	
	return{
		setRegister: function(status){
			register = status;
		},
		getRegister: function(){
			return register;
		}
	};
})