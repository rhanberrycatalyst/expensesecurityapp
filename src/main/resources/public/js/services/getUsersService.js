angular.module("expenseApp").service("getUsersService", ["$http", function($http){
	
	//gets a list of users
	var userList = [$http.get('/users')];
	angular.forEach(userList, function(value, key){
	});
	
	return{
		userList: userList
	};
}]);