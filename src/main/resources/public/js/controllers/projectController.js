angular.module('expenseApp').controller('projectController', ['$scope', '$state', '$http', function($scope, $state, $http){
	$scope.test = function(){
		var obj = {name: 'misko', gender: 'male'};
		var log = [];
		angular.forEach(obj, function(value, key) {
		  console.log(key + ': ' + value);
		});
	}	
}]);