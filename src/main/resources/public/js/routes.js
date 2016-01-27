'use strict';

angular.module('expenseApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/');
	
	$stateProvider.state("home", {
		url: '/',
		templateUrl: 'homeView.html',
		controller: 'homeController'
		})
		.state("login", {
			url: '/loginpage',
			templateUrl: 'login.html',
			controller: 'lginController'
		})
		.state("register", {
			url: '/register',
			templateUrl: 'register.html',
			controller: 'registerController'
		})
		.state("createProject", {
			url: '/createProject',
			templateUrl: 'createProject.html',
			controller: 'projectController'
		})
		.state("createReport", {
			url: '/createReport',
			templateUrl: 'createReport.html',
			controller: 'reportController'
		})
		.state("detailView", {
			url: '/detailView',
			templateUrl: 'detail.html',
			controller: 'detailController'
	});
}]);