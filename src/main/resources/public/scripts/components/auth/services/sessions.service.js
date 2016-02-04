'use strict';

angular.module('expensereportApp')
    .factory('Sessions', function ($resource) {
        return $resource('account/sessions/:series', {}, {
            'getAll': { method: 'GET', isArray: true}
        });
    });



