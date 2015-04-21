/**
 * Created by ernesto on 4/17/15.
 */

'use strict';

angular.module('dxesoftApp')
    .controller('SidemenuController', function ($scope, $location, $state, Principal) {
        $scope.isAuthenticated = Principal.isAuthenticated;
        $scope.isInRole = Principal.isInRole;
        $scope.$state = $state;
        //console.log("state: ", $state);

        //$scope.logout = function () {
        //    Auth.logout();
        //    $state.go('home');
        //};
    });
