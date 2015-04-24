/**
 * Created by ernesto on 4/20/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('Contacto-detailController', function ($scope, $rootScope, Contact, $stateParams) {
        $scope.contactSelected = $rootScope.selectedContact;
        console.log('contact id selected: ', $stateParams.id);
        console.log('contact selected: ', $rootScope.selectedContact);
        console.log('local contact selected: ', $scope.contactSelected);

    });
