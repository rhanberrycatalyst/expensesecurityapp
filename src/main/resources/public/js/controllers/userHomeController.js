angular.module('expenseApp').controller('userHomeController', ['$scope', '$state', '$http', 'getReportService','getCurrentUserService',  function($scope, $state, $http, getReportService, getCurrentUserService){

	//find all current projects
	$scope.statView = 1;
	$scope.allProjects = [];
	$http.get("/projects").then(function(response){
		$scope.allProjects = response.data;
	});
	
	//get the current users information and display their report information
	getCurrentUserService.currentUser()
	.then(function(data){
		$scope.currentUser = data.data;
		$scope.admin = ($scope.currentUser.springrole.roleId == 1);		
		$scope.projectList = [];
		$scope.techReportList = {};
	    $http.get('/projects')
	    .then(function(returnedObject){
	  		angular.forEach(returnedObject.data, function(value, key){
	   			if (value.techId.userId == $scope.currentUser.userId)
	   		    {
	   			    $scope.projectList.push(value); 
	   		    }
	   		});
	  	    getReportService.dbGetAllByProjects($scope.projectList).then(
	  	  		function(success){
	  	  		  $scope.techReportList = success.data;
	  	  		});
	   	});
		$scope.savReportList = [];
		$scope.subReportList = [];
		$scope.appReportList = [];
		$scope.rejReportList = [];
		 
		getReportService.dbGetAll($scope.currentUser.userId).then(
			function(success){
				angular.forEach(success.data, function(value){
					if(value.reportStatus.reportStatus == "Not Submitted")
					{
					  $scope.savReportList.push(value);
					}
					if(value.reportStatus.reportStatus == "Submitted")
					{
					  $scope.subReportList.push(value);					
					}
					if(value.reportStatus.reportStatus == "Approved")
					{
					  $scope.appReportList.push(value);					
					}
					if(value.reportStatus.reportStatus == "Rejected")
					{
					  $scope.rejReportList.push(value);					
					}
				});
			  },function(error){
			  console.log(error);  

			});
		
	});
	
	$scope.loadView = function(id){
		getReportService.setReport(id);

		window.location = "#/home/detailView";
	};
	
	$scope.loadCreate = function(){
		window.location = "#/home/createReport";

	};
	
}]);