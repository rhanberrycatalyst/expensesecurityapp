angular.module('expenseApp').controller('projectController', ['$scope', '$state', '$http', 'getUsersService', 'getDevsService', function($scope, $state, $http, getUsersService, getDevsService){
	$http.get('/users').then(function(data){
		$scope.data = data;
	
		console.log(data);

	});
	$scope.addDev = function(newDev){
		getDevsService.addDev(newDev);
		console.log(newDev);
		$scope.devLists = getDevsService.getDev();
		console.log(getDevsService.getDev());
	};
	$scope.sendProject = function() {
    	console.log(projectName.value);
    	console.log(techLead.value);
        var userData = JSON.stringify({
        		name:projectName.value,
                techId:techLead.value
            })
            console.log(userData)
            $http.post("/projects", userData).
            success(function(data, status, headers, config){
            	console.log(data);
            }).
            error(function(data, status, headers, config){
            	console.log("fail");
            });
    }
}]);