angular.module('expenseApp').controller('registerController', ['$scope', '$state', '$http', 'registerService','authService', function($scope, $state, $http, registerService, authService){

	//saves a newly created user to the database
	function someFunctionCallback(param){
		console.log(param);
	}
	$scope.sendPost = function() {
		$scope.error = false;
        var userData = JSON.stringify({
        		email:userName.value,
                password:passWord.value,
                firstname:firstName.value,
                lastname:lastName.value,
                isActive:true
            })


            $http.post("/register", userData).
            success(function(){
            	registerService.setRegister(true);
            	$state.go("login");
            })
            .error(function(){
            	console.log("Failed to Load Resource");
            	$scope.error = true;
            });
    }
	
	$scope.cancel = function() {
		registerService.setRegister(false);
		authService.setLogout(false);
		$state.go("login");
	}
}]);