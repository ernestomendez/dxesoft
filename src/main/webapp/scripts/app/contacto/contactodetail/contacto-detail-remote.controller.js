/**
 * Created by ernesto on 4/20/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('Contacto-detail-remoteController', function ($scope, Contact, $stateParams, $state, Sharedcontact) {
        $scope.get = function(id) {
            Contact.get({id: id}, function(result) {
                $scope.contactSelected = result;
                Sharedcontact.setContact($scope.contactSelected);
            })
        };

        $scope.get($stateParams.id);

        $scope.edit = function () {
            $state.go('editContact',{id: $scope.contactSelected.id});
        }

    });
