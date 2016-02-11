angular.module('expenseApp').controller('editreportController', ['$scope', '$state', '$http', 'createLineItemService', 'currentUserService', 'getReportService', function($scope, $state, $http, createLineItemService, currentUserService, getReportService){
	

	//Selects report to edit from database
	$scope.reportToEdit = {};
	$scope.reportId = getReportService.curReport;
	getReportService.dbCall($scope.reportId).then(
			  function(success){
				  $scope.reportToEdit = success.data;
				  console.log(success.data);
				  return success.data;
			  },function(error){
				  console.log(error);  
			  }
			  );
	
	
	$scope.getCurrentUser = {"userId":3}; //currentUserService.getCurrentUser();
	$scope.projectList = [];
	$http.get('/projectsusers/' + 3).then(function(data){
		$scope.data = data;
		$scope.curProject = {};
		angular.forEach($scope.data.data, function(value, key){
			$scope.curProject = value;
			angular.forEach(value.endUsers, function(value, key){
				if(value.userId == $scope.getCurrentUser.userId){
					//console.log(value.userId);
					//console.log($scope.getCurrentUser.userId);
					$scope.projectList.push($scope.curProject);
				}
			});
		});
		console.log($scope.projectList);
	});
	

	//below is the controller functionality for creating a report.  
	//The above code selects the correct project, below code provides functionality to edit it.  
	
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
            $http.put("/reports", userData).
            success(function(data, status, headers, config){
            	console.log("editsuccess");
            	window.location="#/home";
            }).
            error(function(data, status, headers, config){
            	console.log("editfail");
            	$scope.error = true;
            });
    };
}]);