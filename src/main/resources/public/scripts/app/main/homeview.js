'use strict';

angular.module('expensereportApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('homeview', {
                parent: 'entity',
                url: '/homeview',
                data: {
                    authorities: [],
                    pageTitle: 'Homeview'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/main/homeView.html',
                        controller: 'homeController'
                    }
                },
                resolve: {
                    
                }
            });
    });