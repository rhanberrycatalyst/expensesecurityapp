angular.module("expenseApp").service("getDevsService", function(){
	var userList = [];
	var addUser = function(newUser){
		userList.push(newUser);
	};
	
	var getDevs = function(){
		return userList;
	};
	
	return{
		addUser: addUser,
		getUser: getUsers
	};
})