angular.module('expenseApp').controller('reportController', ['$scope', '$state', '$http', 'createLineItemService', 'getCurrentUserService', function($scope, $state, $http, createLineItemService, getCurrentUserService){

//	$scope.typetype = {
//		    availableOptions: [
//		      {typeId: '1', value: 'Mileage'},
//		      {typeId: '2', value: 'Per Diem'},
//		      {typeId: '3', value: 'Lodgin'},
//		      {typeId: '4', value: 'Travel'},
//		      {typeId: '5', value: 'Meals'},
//		      {typeId: '6', value: 'Entertainment'},
//		      {typeId: '7', value: 'Parking'},
//		      {typeId: '8', value: 'Other'}
//		    ]};

	getCurrentUserService.currentUser()
	.then(function(data){
		$scope.projectList = [];
		$scope.getCurrentUser = data.data;
		$http.get('/projects/').then(function(data){
			$scope.data = data;
			$scope.curProject = {};
			angular.forEach($scope.data.data, function(value, key){
				$scope.curProject = value;
				angular.forEach(value.endUsers, function(value, key){
					if(value.userId == $scope.getCurrentUser.userId){
						$scope.projectList.push($scope.curProject);
					}
				});
			});
			console.log($scope.projectList);
		});
	});



	$scope.itemList = [];
	$scope.itemType = 1;
	$scope.cost = '';

	$scope.addRow = function(){
		$scope.itemList.push({'type':{'typeId':$scope.itemType}, 'value':$scope.cost});
		$scope.itemType = 1;
		$scope.cost = '';
	};
	$scope.typeDisplay = function(typeID){
		if(typeID == 1){
			return "Mileage";
		}
		else if(typeID == 2){
			return "Per Diem";
		}
		else if(typeID == 3){
			return "Lodging"
		}
		else if(typeID == 4){
			return "Travel"
		}
		else if(typeID == 5){
			return "Meals"
		}
		else if(typeID == 6){
			return "Entertainment"
		}
		else if(typeID == 7){
			return "Parking"
		}
		else if(typeID == 8){
			return "Other"
		}
	};
	$scope.removeItem = function(item){
		var index = $scope.itemList.indexOf(item);
		$scope.itemList.splice(index, 1);
	};
	$scope.sendReport = function() {
        var lineItemsList = $scope.itemList;
        $scope.error = false;
		var userData = angular.toJson({
				endUser:{"userId":$scope.getCurrentUser.userId},
        		name:reportName.value,
        		note:note.value,
        		project:{"projectId":projectName.value},
        		reportStatus:{"reportStatusId":1},
        		lineItems:lineItemsList
            })
            $http.post("/reports", userData).
            success(function(data, status, headers, config){
            	console.log("succss");
            	window.location="#/home";
            }).
            error(function(data, status, headers, config){
            	console.log("fail");
            	$scope.error = true;
            });
    };
}]);
