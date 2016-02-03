angular.module('expenseApp', ['ui.router']);

angular.module('expenseApp').run(($rootScope) => {
	  $rootScope.$on("$stateChangeError", console.log.bind(console));
	});