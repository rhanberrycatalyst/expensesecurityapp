angular.module('expenseApp').controller('homeController', ['$scope', '$state', '$http', 'getReportService','currentUserService', function($scope, $state, $http, getReportService, currentUserService){
	
	$scope.getCurrentUser = currentUserService.getCurrentUser();
	$scope.reportList = {};
	getReportService.dbGetAll($scope.getCurrentUser.userId).then(
			  function(success){
				  $scope.reportList = success.data;
				  console.log(success.data);
				  return success.data;
			  },function(error){
				  console.log(error);  
			  }
			  );
	
	
	$scope.loadView = function(id){
		getReportService.setReport(id);
		window.location = "#/detailView";
	};
	
	$scope.loadCreate = function(){
		window.location = "#/createReport";
	};
	
}]);