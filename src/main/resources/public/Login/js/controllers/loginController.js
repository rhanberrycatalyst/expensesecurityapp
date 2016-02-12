angular.module('expenseApp').controller('loginController', ['$scope', '$state', '$http', '$location','authService', function($scope, $state, $http, $location, authService){
	$scope.logout = authService.getLogout();
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