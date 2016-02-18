 angular.module("expenseApp").service("getProjectsService", ["$http", function($http){
	 
	 //returns all projects
	 function getAllProjects(){
	      return $http.get('/projects');
	  }
	  
	  return {
		  getAllProjects : getAllProjects
	  };
}]);
	