angular.module("loginApp").service("getDevsService", function(){
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