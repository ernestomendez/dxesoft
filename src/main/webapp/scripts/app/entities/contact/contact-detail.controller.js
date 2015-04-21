'use strict';

angular.module('dxesoftApp')
    .controller('ContactDetailController', function ($scope, $stateParams, Contact) {
        $scope.contact = {};
        $scope.load = function (id) {
            Contact.get({id: id}, function(result) {
              $scope.contact = result;
            });
        };
        $scope.load($stateParams.id);
    });
