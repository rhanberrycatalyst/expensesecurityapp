angular.module('expenseApp').controller('navigationController', ['$scope', 'currentUserService', 'getCurrentUserService', '$state', function($scope, currentUserService, getCurrentUserService, $state) {

	getCurrentUserService.currentUser().then(function(success){
        currentUserService.setCurrentUser(success.data);

        // $scope.currentUser = currentUserService.getCurrentUser();
        //$scope.admin = $scope.currentUser.springrole.springRole === 'ROLE_ADMIN';

        getCurrentUserService.currentUser()
    	.then(function(data){
    		$scope.getCurrentUser = data;
    		console.log($scope.getCurrentUser.data);

    		$scope.admin = ($scope.getCurrentUser.data.springrole.roleId == 1);
    		console.log($scope.admin);
    	});

        $scope.admin = $scope.currentUser.springrole.springRole === 'ROLE_ADMIN';

    });


}]);