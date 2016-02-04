angular.module('expensereportApp').controller('homeController', ['$scope', '$state', '$http', 'getReportService', function($scope, $state, $http, getReportService){
	
	$scope.reportList = {};
	getReportService.dbGetAll(1).then(
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
		window.location = "#/detailView"
	}
	
}]);