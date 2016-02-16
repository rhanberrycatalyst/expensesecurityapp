angular.module('expenseApp').controller('registerController', ['$scope', '$state', '$http', 'registerService', function($scope, $state, $http, registerService){

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
            $http.post("/user", userData).
            success(function(){
            	registerService.setRegister(true);
            	$state.go("login");
            })
            .error(function(){
            	console.log("Failed to Load Resource");
            });
    }
}]);