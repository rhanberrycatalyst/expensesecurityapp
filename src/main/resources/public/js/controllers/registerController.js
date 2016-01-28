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
        var data = JSON.stringify({
                username: $scope.userName,
                password: $scope.passWord,
                firstname: $scope.firstName,
                lastname: $scope.lastName
            })
        $http.post("/users", data).success(function(data, status) {
            console.log(data);
        })
    }             
}]);