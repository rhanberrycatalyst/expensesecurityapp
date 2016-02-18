angular.module('expenseApp').controller('loginController', ['$scope', '$state', '$http', '$location','authService','registerService', function($scope, $state, $http, $location, authService, registerService){
	
	$scope.loginFailure = false;
	$scope.logout = authService.getLogout();
	$scope.register = registerService.getRegister();	
	
	//sends the login information entered to the database to see if it's
	//valid or not
	$scope.login = function(){
		$http.post('/loginPage', "username="+$scope.userName+"&password="+$scope.passWord, {
			headers: {'Content-Type':'application/x-www-form-urlencoded', 
				'My-Header': 'value'
			}
		})
		.success(function(data, status, headers, config){

			$scope.loginFailure = false;
			authService.setLogout(true);
			registerService.setRegister(false);
			$state.go("home.userView");
		})
		.error(function(data, status, headers, config){
			console.log("fail");
			$scope.loginFailure = true;
		});
	}
}]);