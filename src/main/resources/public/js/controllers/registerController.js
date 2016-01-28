angular.module('expenseApp').controller('registerController', ['$scope', '$state', '$http', function($scope, $state, $http){
	function validate(){
		var checkUser = "";
		//TO-DO check to see if user name is an e-mail
		
		//TO-DO check to see if user name is taken
		
		//TO-DO check to make sure first name is entered
		//TO-DO check to make sure last name is entered
		//TO-DO check to see if password is at least 8 characters long
		//TO-DO check to see if password has at least 1 number
		//TO-DO check to make sure password and confirm are the same
		submit();
	}
    $scope.sendPost = function() {
    	console.log(userName.value);
        var userData = JSON.stringify({
        		username:userName.value,
                password:passWord.value,
                firstname:firstName.value,
                lastname:lastName.value
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