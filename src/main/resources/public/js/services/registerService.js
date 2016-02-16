angular.module("expenseApp").factory("registerService", function(){
	var register = false;
	
	return{
		setRegister: function(status){
			console.log(status);
			register = status;
			console.log(register);
		},
		getRegister: function(){
			return register;
		}
	};
})