angular.module("expenseApp").service("getUsersService", ["$http", function($http){
	
	var userList = [$http.get('/users')];
	angular.forEach(userList, function(value, key){
	});
	
	return{
		userList: userList
	};
}]);