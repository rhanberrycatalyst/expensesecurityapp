'use strict';

angular.module('expensereportApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('viewreport', {
                parent: 'entity',
                url: '/viewreport',
                data: {
                    authorities: ["ROLE_USER"],
                    pageTitle: 'Viewreport'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/viewreport/detailView.html',
                        controller: 'detailController'
                    }
                },
                resolve: {
                    
                }
            });
    });