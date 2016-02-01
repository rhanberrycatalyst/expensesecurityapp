angular.module('expenseApp').controller('projectController', ['$scope', '$state', '$http', 'getUsersService' function($scope, $state, $http, getUsersService){
	$scope.users = function(){
		var test = getUsersService.getUserList();
		console.log(test);
	};	
}]);