angular.module('expenseApp').controller('reportController', ['$scope', '$state', '$http', 'createLineItemService', function($scope, $state, $http, createLineItemService){
	$scope.itemList = [];
	
	$scope.addRow = function(){
		$scope.itemList.push({'type':{'typeId':$scope.itemType}, 'value':$scope.cost});
		$scope.itemType = '';
		$scope.cost = '';
		console.log($scope.itemList);
	};
	$scope.typeDisplay = function(typeID){
		console.log("test");
		console.log(typeID);
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
        console.log(lineItemsList);
		var userData = angular.toJson({
				endUser:{"userId":5}, //TODO make a meaningful variable
        		name:reportName.value,
        		note:note.value,
        		project:{"projectId":1}, //TODO make a meaningful variable
        		reportStatus:{"reportStatusId":1}, //TODO make a meaningful variable
        		lineItems:lineItemsList
            })
            console.log(userData)
            $http.post("/reports", userData).
            success(function(data, status, headers, config){
            	console.log(data);
            }).
            error(function(data, status, headers, config){
            	console.log("fail");
            });
    };
}]);