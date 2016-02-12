angular.module('expenseApp').controller('homeController', ['$scope', '$state', '$http', 'getReportService','getCurrentUserService', function($scope, $state, $http, getReportService, getCurrentUserService){
	
	getCurrentUserService.currentUser()
	.then(function(data){
		$scope.getCurrentUser = data;
		console.log($scope.getCurrentUser.data.userId);
		$scope.reportList = {};
		getReportService.dbGetAll($scope.getCurrentUser.data.userId).then(
				  function(success){
					  $scope.reportList = success.data;
					  console.log(success.data);
					  return success.data;
				  },function(error){
					  console.log(error);  
				  }
				  );
	});

	
	
	$scope.loadView = function(id){
		getReportService.setReport(id);
		window.location = "#/detailView";
	};
	
	$scope.loadCreate = function(){
		window.location = "#/createReport";
	};
	
}]);