'use strict';

angular.module('expensereportApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('createreport', {
                parent: 'entity',
                url: '/createreport',
                data: {
                    authorities: [],
                    pageTitle: 'Createreport'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/createreport/createReport.html',
                        controller: 'reportController'
                    }
                },
                resolve: {
                    
                }
            });
    });