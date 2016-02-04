'use strict';

angular.module('expensereportApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('createproject', {
                parent: 'entity',
                url: '/createproject',
                data: {
                    authorities: [],
                    pageTitle: 'Createproject'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/project/createProject.html',
                        controller: 'projectController'
                    }
                },
                resolve: {
                    
                }
            });
    });