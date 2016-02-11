angular.module('loginApp').controller('navigationController', ['$scope', 'currentUserService', 'getCurrentUserService', '$state', function($scope, currentUserService, getCurrentUserService, $state) {

	getCurrentUserService.currentUser().then(function(success){
        currentUserService.setCurrentUser(success.data);
        $scope.currentUser = currentUserService.getCurrentUser();
        $scope.admin = $scope.currentUser.springrole.springRole === 'ROLE_ADMIN';
    });


}]);