/**
 * Created by ernesto on 4/20/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('Contacto-detailController', function ($scope, $rootScope, Contact, $stateParams, $state) {
        $scope.contactSelected = $rootScope.selectedContact;

        $scope.edit = function () {
            console.log("Contacto-detailController edit ");

            $state.go('editContact');
        }

    });
