angular.module('expenseApp').controller('navigationController', ['$scope', 'currentUserService', 'getCurrentUserService', '$state', '$http', 'authService', function($scope, currentUserService, getCurrentUserService, $state, $http, authService) {

	//gets the information for the currently logged in user and sets what is
	//seen in the navigation bar based on their role
	getCurrentUserService.currentUser().then(function(success){
        currentUserService.setCurrentUser(success.data);

        //checks to see if there is a currently logged in user and if there
        //isn't redirects to the login page
        getCurrentUserService.currentUser()
    	.then(function(data){
    		$scope.getCurrentUser = data;
 				if ($scope.getCurrentUser.data.userId == null || $scope.getCurrentUser.data.userId == 'undefined') {
    				$state.go("login");
    			}
    		$scope.admin = ($scope.getCurrentUser.data.springrole.roleId == 1);
    	});


       


    });

	//logs out the current user and clears out the session credentials
	$scope.logout = function() {
		  $http.post('/logout', {}).success(function() {
			  authService.setLogout(true);
		  }).error(function(data) {
		    console.log("Failed to logout")
		  });
		};

}]);