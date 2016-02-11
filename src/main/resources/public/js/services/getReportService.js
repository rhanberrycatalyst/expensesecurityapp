 angular.module("expenseApp").service("getReportService", ["$http", function($http){
	
	return {
	  dbCall: function(id){ return $http.get('/reportlist/'+id)},
	  dbGetAll: function(userid){ return $http.get('/reports/'+userid)},
	  setReport: function(id) {this.curReport = id;},
	  curReport: 0
	  };
}]);