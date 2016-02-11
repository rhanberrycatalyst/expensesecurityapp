angular.module('expenseApp').controller('detailController', ['$scope', '$state', '$http', 'getReportService','reportStatusService', function($scope, $state, $http, getReportService,reportStatusService){
	$scope.reportToView = {};
	$scope.reportId = getReportService.curReport;
	console.log($scope.reportId);
	getReportService.dbCall($scope.reportId).then(
			  function(success){
				  $scope.reportToView = success.data;
				  console.log(success.data);
				  return success.data;
			  },function(error){
				  console.log("error---"+error);  
			  }
			  );
	
	$scope.submitx=function()
	{ 
		reportStatusService.dbCallToChangeReportStatus($scope.reportId).then(


				function(success)
			    {	         

				  $scope.message="Report Submitted";

			     },	  
				function(error)
      		  	{
	        	 
					$scope.message="Couldnot submit.Try again";

      		  	}
        		
				
        		 
    		  );};
	
	
}]);