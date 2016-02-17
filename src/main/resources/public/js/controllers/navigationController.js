angular.module('expenseApp').controller('navigationController', ['$scope', 'currentUserService', 'getCurrentUserService', '$state', '$http', 'authService', function($scope, currentUserService, getCurrentUserService, $state, $http, authService) {

	getCurrentUserService.currentUser().then(function(success){
        currentUserService.setCurrentUser(success.data);

        // $scope.currentUser = currentUserService.getCurrentUser();
        //$scope.admin = $scope.currentUser.springrole.springRole === 'ROLE_ADMIN';

        getCurrentUserService.currentUser()
    	.then(function(data){
    		$scope.getCurrentUser = data;
    		console.log($scope.getCurrentUser.data);
 				if ($scope.getCurrentUser.data.userId == null || $scope.getCurrentUser.data.userId == 'undefined') {
    				$state.go("login");
    			}
    		$scope.admin = ($scope.getCurrentUser.data.springrole.roleId == 1);
    		console.log($scope.admin);
    	});

        //$scope.admin = $scope.currentUser.springrole.springRole === 'ROLE_ADMIN';

    });

	$scope.logout = function() {
		  $http.post('/logout', {}).success(function() {
			  authService.setLogout(true);
		  }).error(function(data) {
		    console.log("Failed to logout")
		  });
		};

}]);