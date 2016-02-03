angular.module("expenseApp").service("getReportService", ["$http", function($http){
	
	var dbCall = function(id){ return $http.get('/reports/'+id)};
//	angular.forEach(reportObj, function(value, key){
//	});
	
	return {dbCall: dbCall};
}]);