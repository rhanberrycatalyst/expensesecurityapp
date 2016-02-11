angular.module('expenseApp').controller('userHomeController', ['$scope', '$state', '$http', 'getReportService','currentUserService', function($scope, $state, $http, getReportService, currentUserService){
	
	$scope.statView = 1;
	//$scope.getCurrentUser = currentUserService.getCurrentUser();
	$scope.currentUser = {"userId":2}; //TEMP. REMOVE WHEN UNCOMMENTING ABOVE LINE.
	$scope.admin = currentUserService.getAdmin();
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
  	    	  //console.log($scope.techReportList);
  	  		});
   	});
	$scope.savReportList = [];
	$scope.subReportList = [];
	getReportService.dbGetAll($scope.currentUser.userId).then(
		function(success){
			angular.forEach(success.data, function(value){
				if(value.reportStatus.reportStatusId == 1)
				{
				  $scope.savReportList.push(value);
				}
				if(value.reportStatus.reportStatusId == 2)
				{
				  $scope.subReportList.push(value);					
				}
			});
		  },function(error){
		  console.log(error);  
		});
	
	$scope.loadView = function(id){
		getReportService.setReport(id);
		window.location = "#/detailView";
	};
	
	$scope.loadCreate = function(){
		window.location = "#/createReport";
	};
	
}]);