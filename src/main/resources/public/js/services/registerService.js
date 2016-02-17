angular.module("expenseApp").factory("registerService", function(){
	//check to make sure register ran properly
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