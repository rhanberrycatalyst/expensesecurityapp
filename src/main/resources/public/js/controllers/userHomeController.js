angular.module('expenseApp').controller('userHomeController', ['$scope', '$state', '$http', 'getReportService','currentUserService', function($scope, $state, $http, getReportService, currentUserService){
	
	//$scope.getCurrentUser = currentUserService.getCurrentUser();
	$scope.currentUser = {"userId":2}; //TEMP. REMOVE WHEN UNCOMMENTING ABOVE LINE.
	$scope.admin = currentUserService.getAdmin();
	//$scope.isTechAdmin = {"val":false};
	$scope.projectList = [];
    $http.get('/projects')
    .then(function(returnedObject){
  		angular.forEach(returnedObject.data, function(value, key){
			//console.log(value.techId.userId + " == " + $scope.currentUser.userId + "?");
   			if (value.techId.userId == $scope.currentUser.userId)
   		    {
   			    $scope.projectList.push(value); 
   		    }
   		});
   	});
	$scope.reportList = {};
	getReportService.dbGetAll($scope.currentUser.userId).then(
		function(success){
			$scope.reportList = success.data;
				//console.log(success.data);
				return success.data;
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