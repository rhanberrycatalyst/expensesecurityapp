'use strict';
//angular routing information
angular.module('expenseApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

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
			templateUrl: 'templates/userView.html',
			controller: 'navigationController'
		})
		.state("home.userView", {
			url: '/homeView',
			templateUrl: 'templates/userHomeView.html',
			controller: 'userHomeController'
		})
		.state("home.createReport", {
			url: '/createReport',
			templateUrl: 'templates/createReport.html',
			controller: 'reportController'
		})
		.state("home.editReport", {
			url: '/editReport',
			templateUrl: 'templates/editReport.html',
			controller: 'editreportController'
		})
		.state("home.createProject", {
			url: '/createProject',
			templateUrl: 'templates/createProject.html',
			controller: 'projectController'
		})
		.state("home.detailView", {
			url: '/detailView',
			templateUrl: 'templates/detailView.html',
			controller: 'detailController'

		})

}]);

