
angular.module('expenseApp').controller('detailController', ['$scope', '$state', '$http', 'getReportService','reportStatusService', function($scope, $state, $http, getReportService,reportStatusService){
	$scope.reportToView = {};
	
	$scope.reportId = getReportService.curReport;
console.log("$scope.reportId"+$scope.reportId);
	if($scope.reportId == 0)
	{
	  //If the page was refreshed and we lost the reportId, (it will default back to 0)
	  //then go back a page.
	  //This should also have the side benefit of recalling the various stored info
	  //on the previous page.
	  history.go(-1);
	}
	else{
	  getReportService.dbCall($scope.reportId).then(

		  function(success){
				  $scope.reportToView = success.data;
				  $scope.submitted=success.data.reportStatus.reportStatus === 'Submitted';
				 
				  console.log(success.data);
				  
				  return success.data;
			  },function(error){

				  console.log(error);
			  }
			  );
	}
	
		
	
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
