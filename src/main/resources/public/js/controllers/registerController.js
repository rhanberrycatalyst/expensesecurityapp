angular.module('expenseApp').controller('registerController', ['$scope', '$state', '$http', function($scope, $state, $http){
	function validate(){
		var checkUser = "";
		//TO-DO check to see if user name is an e-mail
		
		//TO-DO check to see if user name is taken
		$http.get("database call on username")
		.then(function(response){
			checkUser = response.data;
			if(checkUser == $scope.userName)
				{
					//error username already taken
				}
			else
				{
					//userName pass
				}
		})
		//TO-DO check to make sure first name is entered
		//TO-DO check to make sure last name is entered
		//TO-DO check to see if password is at least 8 characters long
		//TO-DO check to see if password has at least 1 number
		//TO-DO check to make sure password and confirm are the same
		submit();
	}
	function submit(){
		
	}
}]);