angular.module('expenseApp').controller('projectController', ['$scope', '$state', '$http', 'getUsersService', function($scope, $state, $http, getUsersService){
	$http.get('/users').then(function(data){
		$scope.data = data;
	
		angular.forEach($scope.data, function(value, key){
		console.log(data);
		});
	});
}]);