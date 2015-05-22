/**
 * Created by ernesto on 5/20/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('Edit-contactController', function($scope, $rootScope, Contact, $stateParams, contact_utils, $modalInstance, $state) {

        console.log("aqui estoy!!!", $scope.selectedContact);
        $scope.contact = $scope.selectedContact;

        $scope.phoneTypeOptions = contact_utils.getPhoneTypeOptions();
        $scope.emailTypeOptions = contact_utils.getEmailTypeOptions();
        $scope.addressTypeOptions = contact_utils.getAddressTypeOptions();

        //$scope.contact.phoneList = [{phoneType: $scope.phoneTypeOptions[0].code, phoneNumber:"" }];
        //$scope.contact.emailList = [{emailType: $scope.emailTypeOptions[0].code, email:""}];
        //$scope.contact.addressList = [{addressType: $scope.addressTypeOptions[0].code,
        //    street:"",
        //    number_ext: "",
        //    number_int: "",
        //    zipcode: ""
        //}];

    });
