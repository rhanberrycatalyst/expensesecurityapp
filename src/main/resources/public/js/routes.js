'use strict';

angular.module('expenseApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/index');
	
	$stateProvider
		.state("index", {
			url: '/',
			templateUrl: '/index.html'
		})
		.state("home", {
			url: '/home',
			templateUrl: 'templates/userHomeView.html',
			controller: 'userHomeController'
		})
		.state("adminHome", {
			url: '/admin',
			templateUrl: 'templates/adminHomeView.html',
			controller: 'adminHomeController'
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
		})
		.state("editReport", {
			url: '/editReport',
			templateUrl: 'templates/editReport.html',
			controller: 'editreportController'
	});
}]);