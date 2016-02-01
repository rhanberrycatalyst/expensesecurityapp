angular.module("expenseApp").service("getUsersService", ["$http", function($http){
	
	var userList = [$http.get('/users')];
	console.log(userList);
	angular.forEach(userList, function(value, key){
		console.log(key + ': ' + value);
	});
	
	return{
		userList: userList
	};
}]);