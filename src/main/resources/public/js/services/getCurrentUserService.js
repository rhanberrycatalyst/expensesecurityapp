angular.module('expenseApp').service('getCurrentUserService', ['$http', 'currentUserService', function($http, currentUserService)
{
	
	 //Requests the current users information
	  function currentUser(){
	      return $http.get('/security/current');
	  }
	  
//	  function currentUserObject(){
//		  $http.get('/security/current').then(function(data){
//			  console.log(data.data);
//			  this.something=data.data;
//		  });
//	  }
	  return {
		  currentUser : currentUser
//		  currentUserObject: currentUserObject,
//		  something : {}
	  };
	  
	
}]);