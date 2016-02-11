angular.module('expenseApp').service('reportStatusService', ['$http',  function($http)
{
	return {
  	  dbCallToChangeReportStatus: function(reportId){
		  return $http.put('/reportsubmitted/'+reportId);
	  }
	};
}]);