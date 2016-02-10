angular.module('loginApp', ['ui.router']);

angular.module('loginApp').run(($rootScope) => {
	  $rootScope.$on("$stateChangeError", console.log.bind(console));
	});