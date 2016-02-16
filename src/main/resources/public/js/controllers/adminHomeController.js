angular.module('expenseApp').controller('adminHomeController', ['$scope', '$state', '$http', 'getProjectsService','currentUserService', function($scope, $state, $http, getProjectsService, currentUserService){
	
	$scope.getCurrentUser = currentUserService.getCurrentUser();
	//$scope.admin = currentUserService.getAdmin();
	$scope.projectList = {};
	getProjectsService.getAllProjects().then(
		function(success){
			$scope.projectList = success.data;
				console.log(success.data);
				return success.data;
			},function(error){
				console.log(error);  
		});
	
	$scope.loadView = function(id){
		//getReportService.setReport(id);
		//window.location = "#/detailView";
	};
	
	//$scope.loadCreate = function(){
		//window.location = "#/createReport";
	//};
	
}]);