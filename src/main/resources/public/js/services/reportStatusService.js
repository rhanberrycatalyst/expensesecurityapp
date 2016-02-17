angular.module('expenseApp').service('reportStatusService', ['$http',  function($http)
{
	//changes a reports status to submitted
	return {
  	  dbCallToChangeReportStatus: function(reportId){
		  return $http.put('/reportsubmitted/'+reportId);
	  }
	};
}]);