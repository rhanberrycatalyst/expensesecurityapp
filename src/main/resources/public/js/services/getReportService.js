angular.module("expenseApp").service("getReportService", ["$http", function($http){
	
	var dbCall = function(id){ return $http.get('/reportlist/'+id)};
//	angular.forEach(reportObj, function(value, key){
//	});
	var dbGetAll = function(userid){ return $http.get('/reports/'+userid)};
	
	return {dbCall: dbCall, dbGetAll: dbGetAll};
}]);