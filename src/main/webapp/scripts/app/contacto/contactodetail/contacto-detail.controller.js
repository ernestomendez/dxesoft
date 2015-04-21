/**
 * Created by ernesto on 4/20/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('Contacto-detailController', function ($scope, $rootScope, Contact, ParseLinks, $state, $stateParams) {
        $scope.contactSelected = $stateParams.id;
        console.log('contact id selected: ', $scope.contactSelected);
        console.log('contact selected: ', $rootScope.contact)
    });
