angular.module('loginApp').controller('registerController', ['$scope', '$state', '$http', function($scope, $state, $http){

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
            success(function(data, status, headers, config){
            	$state.go("login")
            }).
            error(function(data, status, headers, config){
            	console.log("fail");
            });
    }
}]);