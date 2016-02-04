angular.module('expenseApp').controller('detailController', ['$scope', '$state', '$http', 'getReportService', function($scope, $state, $http, getReportService){
	$scope.reportToView = {};
	$scope.reportId = getReportService.curReport;
	getReportService.dbCall($scope.reportId).then(
			  function(success){
				  $scope.reportToView = success.data;
				  console.log(success.data);
				  return success.data;
			  },function(error){
				  console.log(error);  
			  }
			  );
	
	
}]);