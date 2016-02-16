angular.module('expenseApp').controller('userHomeController', ['$scope', '$state', '$http', 'getReportService','getCurrentUserService',  function($scope, $state, $http, getReportService, getCurrentUserService){
	
	$scope.statView = 1;
	$scope.allProjects = [];
	$http.get("/projects").then(function(response){
		$scope.allProjects = response.data;
		console.log($scope.allProjects);
	});
	
	//$scope.getCurrentUser = currentUserService.getCurrentUser();
	//$scope.currentUser = {"userId":2}; //TEMP. REMOVE WHEN UNCOMMENTING ABOVE LINE.
	getCurrentUserService.currentUser()
	.then(function(data){
		$scope.currentUser = data.data;
		console.log($scope.currentUser.springrole.roleId);

		$scope.admin = ($scope.currentUser.springrole.roleId == 1);
		console.log($scope.admin);
		
		$scope.projectList = [];
		$scope.techReportList = {};
	    $http.get('/projects')
	    .then(function(returnedObject){
	  		angular.forEach(returnedObject.data, function(value, key){
	   			if (value.techId.userId == $scope.currentUser.userId)
	   		    {
	   			    $scope.projectList.push(value); 
	   		    }
	   		});
	  	    getReportService.dbGetAllByProjects($scope.projectList).then(
	  	  		function(success){
	  	  		  $scope.techReportList = success.data;
	  	    	  //console.log($scope.techReportList);
	  	  		});
	   	});
		$scope.savReportList = [];
		$scope.subReportList = [];
		/*//FOR FUTURE CARDS
		$scope.appReportList = [];
		$scope.rejReportList = [];
		 */
		getReportService.dbGetAll($scope.currentUser.userId).then(
			function(success){
				angular.forEach(success.data, function(value){
					if(value.reportStatus.reportStatus == "Not Submitted")
					{
					  $scope.savReportList.push(value);
					}
					if(value.reportStatus.reportStatus == "Submitted")
					{
					  $scope.subReportList.push(value);					
					}
					/*//FOR FUTURE CARDS
					if(value.reportStatus.reportStatus == "Approved")
					{
					  $scope.appReportList.push(value);					
					}
					if(value.reportStatus.reportStatus == "Rejected")
					{
					  $scope.rejReportList.push(value);					
					}*/
				});
			  },function(error){
			  console.log(error);  
			});
		
	});
	
	$scope.loadView = function(id){
		getReportService.setReport(id);
		window.location = "#/home/detailView";
	};
	
	$scope.loadCreate = function(){
		window.location = "#/home/createReport";
	};
	
}]);