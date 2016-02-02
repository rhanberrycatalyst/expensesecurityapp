'use strict';

angular.module('expenseApp').config(['$stateProvider', '$urlRouterProvider', '$httpProvider', '$locationProvider',function($stateProvider, $urlRouterProvider, $httpProvider, $locationProvider){
	$urlRouterProvider.otherwise('/');
	$locationProvider.html5Mode(true);

	$stateProvider.state("index", {
		url: '/',
		templateUrl: 'index.html'
		})
		.state("login", {
			url: '/login',
			templateUrl: 'public/templates/login.html',
			controller: 'loginController'
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
			templateUrl: 'templates/detail.html',
			controller: 'detailController'
	});

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	}]).run(function(auth){
		//initializes the auth module on home page load and login/logout
		auth.init('/','/login','/logout');
	console.log("routes work");
	});