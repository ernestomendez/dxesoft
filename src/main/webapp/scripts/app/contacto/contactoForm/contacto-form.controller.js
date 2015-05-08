/**
 * Created by ernesto on 5/3/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('Contacto-formController', function($scope, $rootScope, Contact, $stateParams, contact_utils) {
        //$scope.newContact = '';
        console.log('Contacto-formController');

        $scope.contact = {};
        $scope.phoneTypeOptions = contact_utils.getPhoneTypeOptions();
        $scope.contact.phoneType = $scope.phoneTypeOptions[0];
        $scope.emailTypeOptions = contact_utils.getEmailTypeOptions();
        $scope.contact.emailType = $scope.emailTypeOptions[0];
        console.log("phone type options: ", $scope.phoneTypeOptions);
        console.log("email type options: ", $scope.emailTypeOptions);

        var phones = [{phoneType: $scope.phoneTypeOptions[0], },
            {}];

    });
