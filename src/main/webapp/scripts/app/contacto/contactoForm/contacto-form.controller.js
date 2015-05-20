/**
 * Created by ernesto on 5/3/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('Contacto-formController', function($scope, $rootScope, Contact, $stateParams, contact_utils, $modalInstance, $state) {
        $scope.contact = {};
        $scope.phoneTypeOptions = contact_utils.getPhoneTypeOptions();
        $scope.emailTypeOptions = contact_utils.getEmailTypeOptions();
        $scope.addressTypeOptions = contact_utils.getAddressTypeOptions();

        $scope.contact.phoneList = [{phoneType: $scope.phoneTypeOptions[0].code, phoneNumber:"" }];
        $scope.contact.emailList = [{emailType: $scope.emailTypeOptions[0].code, email:""}];
        $scope.contact.addressList = [{addressType: $scope.addressTypeOptions[0].code,
                                       street:"",
                                       number_ext: "",
                                       number_int: "",
                                       zipcode: ""
        }];

        $scope.addPhone = function(index) {
            $scope.contact.phoneList.push({phoneType: $scope.phoneTypeOptions[++index].code, phoneNumber:"" });
        };

        $scope.removePhone = function(index) {
            console.log("index: ", index);

            $scope.contact.phoneList.splice(index, 1);
        };

        $scope.addEmail = function(index) {
            $scope.contact.emailList.push({emailType: $scope.emailTypeOptions[++index].code, email:"" });
        };

        $scope.removeEmail = function(index) {
            console.log("index: ", index);

            $scope.contact.emailList.splice(index, 1);
        };

        $scope.addAddress = function(index) {
            $scope.contact.addressList.push({addressType: $scope.addressTypeOptions[++index].code,
                street:"",
                number_ext: "",
                number_int: "",
                zipcode: "" });
        };

        $scope.removeAddress = function(index) {
            console.log("index: ", index);

            $scope.contact.addressList.splice(index, 1);
        };

        $scope.create = function () {
            $scope.prepareContact();

            $scope.contact = Contact.post($scope.contact,
                function(result) {
                    $state.go('detailContact', {id:$scope.contact.id});
                    $modalInstance.close();
                }
            );
        };

        $scope.clear = function () {
            console.log("clear");
            $scope.contact = {nombres: null, apellidoPaterno: null, apellidoMaterno: null, gender: null, birthDate: null, company: null, title: null, facebook: null, tiwtter: null, legalId: null, owner: null, creationDate: null, dxesoftCompany: null, id: null, phoneTypeId: null, phoneList: null, emailList: null, addressList: null};
            $scope.contactEditForm.$setPristine();
            $scope.contactEditForm.$setUntouched();

            $modalInstance.dismiss('cancel');
            $state.go('detail');
        };

        $scope.prepareContact = function() {
            console.log("prepare contact");

            contact_utils.removeEmptyElementsFromList($scope.contact.phoneList, "phoneNumber");
            contact_utils.removeEmptyElementsFromList($scope.contact.emailList, "email");
            contact_utils.removeEmptyElementsFromList($scope.contact.addressList, "street");

            $scope.contact.creationDate= new Date();
            console.log("creation date: ", $scope.contact.creationDate);
            $scope.contact.dxesoftCompany="Dxesoft";

        };

        $scope.open = function($event) {
            $event.preventDefault();
            $event.stopPropagation();

            $scope.opened = true;
        };

        $scope.dateOptions = {
            formatYear: 'yyyy',
            startingDay: 1,
            "year-range": 30
        };

    });
