angular.module('expenseApp').controller('loginController', ['$scope', '$state', '$http', '$location','authService','registerService', function($scope, $state, $http, $location, authService, registerService){
	$scope.logout = authService.getLogout();
	$scope.register = registerService.getRegister();
	$scope.login = function(){
		$http.post('/loginPage', "username="+$scope.userName+"&password="+$scope.passWord, {
			headers: {'Content-Type':'application/x-www-form-urlencoded', 
				'My-Header': 'value'
			}
		})
		.success(function(data, status, headers, config){
			authService.setLogout(true);
			$state.go("home.userView");
		})
		.error(function(data, status, headers, config){
			console.log("fail");
		});
	}
}]);