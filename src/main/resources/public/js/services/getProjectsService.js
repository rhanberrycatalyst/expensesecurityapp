 angular.module("expenseApp").service("getProjectsService", ["$http", function($http){
	 function getAllProjects(){
	      return $http.get('/projects');
	  }
	  
	  return {
		  getAllProjects : getAllProjects
	  };
}]);
	