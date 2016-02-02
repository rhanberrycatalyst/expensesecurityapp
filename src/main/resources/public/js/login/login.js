'use strict';

angular.module('expenseApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('login', {
                parent: 'account',
                url: '/login',
                data: {
                    authorities: [],
                    pageTitle: 'Sign in'
                },
                views: {
                    'content@': {
                        templateUrl: 'public/js/login/login.html',
                        controller: 'LoginController'
                    }
                },
                });
    });
