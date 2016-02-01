angular.module("expenseApp").service("getUsersService", ["$http", function($http){
	var userList = [];
	
	return{
		initUserList: function(){
			$http.get("/users").success(function(data){
			userList.length = 0;
			userList.push.apply(userList, data);
			}).error(error);
		},
	getUserList: userList
	}
}]);