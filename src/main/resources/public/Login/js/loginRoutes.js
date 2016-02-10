'use strict';

angular.module('loginApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/login');
	
	$stateProvider
		.state("index", {
			url: '/',
			templateUrl: 'Login/loginIndex.html'
		})
		.state("login", {
			url: '/login',
			templateUrl: 'Login/templates/login.html',
			controller: 'loginController'
		})
		.state("register", {
			url: '/register',
			templateUrl: 'Login/templates/register.html',
			controller: 'registerController'
		});
}]);