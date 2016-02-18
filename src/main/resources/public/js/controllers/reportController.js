angular.module('expenseApp').controller('reportController', ['$scope', '$state', '$http', 'createLineItemService', 'getCurrentUserService', function($scope, $state, $http, createLineItemService, getCurrentUserService){

	//gets the currently logged in user's information and fills the project
	//drop down with projects they are currently associated with
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
		});
	});

	$scope.itemList = [];
	$scope.itemType = 1;
	$scope.cost = '';

	//add a line item to the report
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
	//removes a line item from the report
	$scope.removeItem = function(item){
		var index = $scope.itemList.indexOf(item);
		$scope.itemList.splice(index, 1);
	};
	//saves the report to the database
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
            	window.location="#/home/homeView";
            }).
            error(function(data, status, headers, config){
            	$scope.error = true;
            });
    };
}]);
