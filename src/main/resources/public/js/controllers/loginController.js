angular.module('expenseApp', ['ngRoute','ui.router','auth']).controller(
    'loginController',

    function($scope, $route, auth) {

        $scope.credentials = {};

        $scope.tab = function(route) {
            return $route.current && route === $route.current.controller;
        };

        $scope.authenticated = function() {
            return auth.authenticated;
        }

        $scope.login = function() {
            auth.authenticate($scope.credentials, function(authenticated) {
                if (authenticated) {
                    console.log("Login succeeded")
                    $scope.error = false;
                } else {
                    console.log("Login failed")
                    $scope.error = true;
                }
            })
        };

        $scope.logout = auth.clear;

        console.log("Logincontroller works");

    });
