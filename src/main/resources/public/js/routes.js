'use strict';

angular.module('expenseApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/index');
	
	$stateProvider.state("index", {
<<<<<<< HEAD
		url: '/',
		templateUrl: 'templates/homeView.html',
		controller: 'homeController'
=======
		url: '/index',
		templateUrl: 'index.html'
>>>>>>> origin/AngularAuthenticationIssue
		})
		.state("login", {
			url: '/',
			templateUrl: '/login.html',
			controller: 'LoginJs/loginController'
		})
		.state("home", {
			url: '/home',
			templateUrl: 'templates/homeView.html',
			controller: 'homeController'
		})
		.state("register", {
			url: '/register',
			templateUrl: 'templates/register.html',
			controller: 'registerController'
		})
		.state("createProject", {
			url: '/createProject',
			templateUrl: 'templates/createProject.html',
			controller: 'projectController'
		})
		.state("createReport", {
			url: '/createReport',
			templateUrl: 'templates/createReport.html',
			controller: 'reportController'
		})
		.state("detailView", {
			url: '/detailView',
			templateUrl: 'templates/detailView.html',
			controller: 'detailController'
	});
}]);