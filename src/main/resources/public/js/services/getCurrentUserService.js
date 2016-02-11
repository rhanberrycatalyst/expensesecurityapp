angular.module('loginApp').service('getCurrentUserService', ['$http', 'currentUserService', function($http, currentUserService)
{
	
	 //Requests the current users information
	  function currentUser(){
	      return $http.get('/security/current');
	  }
	  
	  return {
		  currentUser : currentUser
	  };
	  
	
}]);