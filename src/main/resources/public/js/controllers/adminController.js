angular.module('expenseApp').controller('adminController', ['$scope', '$state', '$http', 'createLineItemService', 'currentUserService', function($scope, $state, $http, createLineItemService, currentUserService){
	
	$scope.admin = currentUserService.getAdmin();
}]);