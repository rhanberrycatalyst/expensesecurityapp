angular.module('loginApp').controller('registerController', ['$scope', '$state', '$http', function($scope, $state, $http){

	$scope.usernameAvailable = function(){
		$http({
			method: "GET",
			url: '/userss/' + userName.value
		}).then(function (data) {
	          callback(data);
	     });
	}
	function someFunctionCallback(param){
		console.log(param);
	}
	$scope.sendPost = function() {
    	console.log(userName.value);
        var userData = JSON.stringify({
        		springroleid:2,
        		email:userName.value,
                password:passWord.value,
                firstname:firstName.value,
                lastname:lastName.value,
                isActive:true
            })
            console.log(userData)
            $http.post("/users", userData).
            success(function(data, status, headers, config){
            	console.log(data);
            }).
            error(function(data, status, headers, config){
            	console.log("fail");
            });
    }
}]);