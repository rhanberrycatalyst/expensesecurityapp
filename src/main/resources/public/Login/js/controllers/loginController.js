angular.module('expenseApp').controller('loginController', ['$scope', '$state', '$http', '$location','authService','registerService','getCurrentUserService','currentUserService', function($scope, $state, $http, $location, authService, registerService,getCurrentUserService,currentUserService){
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
			registerService.setRegister(false);
			getCurrentUserService.currentUser().then(function(success){
		        currentUserService.setCurrentUser(success.data);
		        
		        $scope.admin = success.data.springrole.springRole === 'ROLE_ADMIN';
		        console.log(" from function $scope.admin"+ $scope.admin);
			
			console.log(" $scope.admin"+ $scope.admin);
	        if(!($scope.admin))
        	{
	        $state.go("home.userView");
        	}
        else
        	{
        	$state.go("home.adminHome");
        	}
			});

		})
		.error(function(data, status, headers, config){
			console.log("fail");
		});
	}
}]);