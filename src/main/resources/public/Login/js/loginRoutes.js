'use strict';

angular.module('loginApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/login');
	
	$stateProvider
		.state("login", {
			url: '/login',
			templateUrl: 'Login/templates/login.html',
			controller: 'loginController'
		})
		.state("register", {
			url: '/register',
			templateUrl: 'Login/templates/register.html',
			controller: 'registerController'
		})
		.state("home", {
			url: '/home',
			templateUrl: 'Login/templates/partial-home.html'
		})
		.state("home.view", {
			url: '/homeView',
			templateUrl: 'Login/templates/homeView.html',
			controller: 'homeController'
		})
		.state("home.createReport", {
			url: '/createReport',
			templateUrl: 'Login/templates/createReport.html',
			controller: 'reportController'
		})
		.state("home.createProject", {
			url: '/createProject',
			templateUrl: 'Login/templates/createProject.html',
			controller: 'projectController'
		})
}]);