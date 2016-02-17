angular.module('expenseApp').controller('registerController', ['$scope', '$state', '$http', 'registerService','authService', function($scope, $state, $http, registerService, authService){

	function someFunctionCallback(param){
		console.log(param);
	}
	$scope.sendPost = function() {
    	console.log(userName.value);
        var userData = JSON.stringify({
        		email:userName.value,
                password:passWord.value,
                firstname:firstName.value,
                lastname:lastName.value,
                isActive:true
            })
            console.log(userData)
            $http.post("/register", userData).
            success(function(){
            	registerService.setRegister(true);
            	$state.go("login");
            })
            .error(function(){
            	console.log("Failed to Load Resource");
            });
    }
	
	$scope.cancel = function() {
		registerService.setRegister(false);
		authService.setLogout(false);
		$state.go("login");
	}
}]);