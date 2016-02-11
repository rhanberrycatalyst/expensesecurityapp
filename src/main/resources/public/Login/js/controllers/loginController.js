angular.module('loginApp').controller('loginController', ['$scope', '$state', '$http', '$location', function($scope, $state, $http, $location){
	
	$scope.login = function(){
		console.log($scope.userName);
		console.log($scope.passWord);
		console.log({email:$scope.userName, password:$scope.passWord});
		//var headers = {authorization : "Basic " + btoa($scope.userName + ":" + $scope.passWord)};
		$http.post('/loginPage', "username="+$scope.userName+"&password="+$scope.passWord, {
			headers: {'Content-Type':'application/x-www-form-urlencoded', 
				'My-Header': 'value'
			}
		})
		.success(function(data, status, headers, config){
			$state.go("home.view");
		})
		.error(function(data, status, headers, config){
			console.log("fail");
		});
	}
}]);