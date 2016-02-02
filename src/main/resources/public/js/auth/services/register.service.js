'use strict';

angular.module('expenseApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


