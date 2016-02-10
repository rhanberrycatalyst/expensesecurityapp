angular.module('loginApp').controller('loginController', ['$scope', '$state', '$http', '$location', function($scope, $state, $http, $location){
	
	$scope.login = function(){
		console.log($scope.userName);
		console.log($scope.passWord);
		console.log({email:$scope.userName, password:$scope.passWord});
		//var headers = {authorization : "Basic " + btoa($scope.userName + ":" + $scope.passWord)};
		$http.post('/loginPage', {email:$scope.userName, password:$scope.passWord})
		.success(function(data, status, headers, config){
			window.location="#/createProject"
		})
		.error(function(data, status, headers, config){
			console.log("fail");
		});
	}
}]);