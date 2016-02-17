angular.module("expenseApp").service("getDevsService", function(){
	
	//holds a list of devs
	var devList = [];
	var addDev = function(newDev){
		devList.push(newDev);
	};
	
	var getDevs = function(){
		return devList;
	};
	
	return{
		addDev: addDev,
		getDev: getDevs
	};
})