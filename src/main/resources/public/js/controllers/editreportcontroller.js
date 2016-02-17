angular.module('expenseApp').controller('editreportController', ['$scope', '$state', '$http', 'createLineItemService', 'getCurrentUserService', 'getReportService', function($scope, $state, $http, createLineItemService, getCurrentUserService, getReportService){

	$scope.itemList = [];

	$scope.reportToEdit = {};
	$scope.reportId = getReportService.curReport;
	if($scope.reportId == 0)
	{
		//If the page was refreshed and we lost the reportId, (it will default back to 0)
		//then go back a page.
		//This should also have the side benefit of recalling the various stored info
		//on the previous page.
		history.go(-1);
	}
	else{
		getReportService.dbCall($scope.reportId).then(
			function(success){
				$scope.reportToEdit = success.data;
				angular.forEach($scope.reportToEdit.lineItems, function(value){
					
					$scope.itemList.push(value);
					
				});
				console.log($scope.itemList);
//				for(var x = 0; x<$scope.reportToEdit.lineItems.length;x++)
//				{
//					$scope.itemList.push({'type':{'typeId':$scope.reportToEdit.lineItems[x].type.typeId}, 'value':$scope.reportToEdit.lineItems[x].value});
//				}
				console.log(success.data);
				return success.data;
			},function(error){
				console.log(error);
			}
		);
	}

/*	$scope.getCurrentUser = {"userId":3}; //currentUserService.getCurrentUser();
	$scope.projectList = [];
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
	});*/
	getCurrentUserService.currentUser()
		.then(function(data){
			$scope.projectList = [];
			$scope.getCurrentUser = data.data;
			$http.get('/projectsusers/' + $scope.getCurrentUser.userId).then(function(data){
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
				//console.log($scope.projectList);
			});
		});


	//below is the controller functionality for creating a report.
	//The above code selects the correct projects for a given user, below code provides functionality to edit the report.

	
	$scope.itemType = 1;
	$scope.cost = '';

	$scope.addRow = function(){
		console.log({'report':{'reportId':$scope.reportId}, 'type':{'typeId':$scope.itemType}, 'value':$scope.cost});
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

	$scope.sendEditedReport = function() {
		var lineItemsList = $scope.itemList;
		$scope.error = false;
		var userData = angular.toJson({
			reportId: $scope.reportId,
			endUser:{"userId":$scope.reportToEdit.endUser.userId}, //userid from the specific report
			name:reportName.value,
			note:note.value,
			project:{"projectId":projectName.value},
			reportStatus:{"reportStatusId":1},
			lineItems:lineItemsList
		});
		console.log(userData);
		$http.put("/reports", userData).
		success(function(data, status, headers, config){
			console.log("editsuccess");
			window.location="#/home/homeView";
		}).
		error(function(data, status, headers, config){
			console.log("editfail");
			$scope.error = true;
		});
	};
}]);
