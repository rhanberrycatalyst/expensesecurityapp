angular.module("expenseApp").service("createLineItemService", function(){
	var itemList = [];
	var addItem = function(newItem){
		itemList.push(newItem);
	};
	
	var getItems = function(){
		return itemList;
	};
	
	return{
		addItem: addItem,
		getItem: getItems
	};
})