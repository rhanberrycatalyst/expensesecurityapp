angular.module('expenseApp').controller('projectController', ['$scope', '$state', '$http', 'getUsersService', 'getDevsService', function($scope, $state, $http, getUsersService, getDevsService){
	
	$scope.devLists = getDevsService.clearDevs();
	//gets a list of all developers
	$http.get('/users').then(function(data){
		$scope.data = data;
	});
	$scope.projectName = "";
	//add a dev to the dev list associated with the project
	$scope.addDev = function(newDev){
		$scope.devName = document.getElementById('developers')[document.getElementById('developers').selectedIndex].text;
		$scope.curDev = {"userId": newDev, "nomdeplume": $scope.devName};
		console.log($scope.devLists)
		getDevsService.addDev($scope.curDev);
		$scope.devLists = getDevsService.getDev();
		console.log($scope.devLists);
	};
	//checks to see if a project name is unique
	$scope.projectNameAvailable = function(){
		$http({
			method: "GET",
			url: '/userss/' + userName.value
		}).then(function (data) {
	          callback(data);
	    });
	}
	//saves the project and it's information to the database
	$scope.sendProject = function() {
		$scope.worked = false;
		$scope.error = false;
        var userData = JSON.stringify({
        		name:projectName.value,
                techId:{"userId":techLead.value},
        		endUsers: $scope.devLists
            })
            $http.post("/projects", userData).
            success(function(data, status, headers, config){
            	$scope.worked = true;
            	window.location="#/home/homeView";
            }).
            error(function(data, status, headers, config){
            	$scope.error = true;
            });
    }
}]);