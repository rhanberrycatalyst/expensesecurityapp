angular.module("expenseApp").service("getDevsService", function(){
	
	//holds a list of devs
	var addDev = function(newDev){
		this.devList.push(newDev);
	};
	
	var getDevs = function(){
		return this.devList;
	};
	
	var clearDevs = function(){
		this.devList.splice(0,this.devList.length);
		return [];
	};
	
	return{
		devList: [],
		addDev: addDev,
		getDev: getDevs,
		clearDevs: clearDevs
	};
})