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
	$scope.projectNameAvailable = function(){
		$http({
			method: "GET",
			url: '/userss/' + userName.value
		}).then(function (data) {
	          callback(data);
	    });
	}
	$scope.sendProject = function() {
		$scope.worked = false;
		$scope.error = false;
    	console.log(projectName.value);
    	console.log(techLead.value);
        var userData = JSON.stringify({
        		name:projectName.value,
                techId:{"userId":techLead.value}
            })
            console.log(userData)
            $http.post("/projects", userData).
            success(function(data, status, headers, config){
            	console.log("success");
            	$scope.worked = true;
            }).
            error(function(data, status, headers, config){
            	console.log("fail");
            	$scope.error = true;
            });
        //TO-DO will need a second post for the list of devs
    }
}]);