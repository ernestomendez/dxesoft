/**
 * Created by ernesto on 4/18/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('ContactosController', function ($scope, Contact, ParseLinks, $state, $rootScope, Sharedcontact) {
        $scope.contacts = [];
        $scope.page = 1;
        $scope.loadAll = function() {
            Contact.query({page: $scope.page, per_page: 20}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.contacts = result;
                Sharedcontact.setContactList($scope.contacts);
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };

        $scope.loadAll();
        $scope.selectedRow = null;

        $scope.setSelected = function (contact) {
            console.log("set selected");
            $scope.selectedContact = contact;
            $state.go('detailContact', {id: $scope.selectedContact.id});
        };

        $scope.isActive = function(contact) {
            if($scope.selectedContact != undefined) {
                return $scope.selectedContact.id === contact.id;
            }
        };

        $scope.findBy = function() {
            console.log($scope.searchContact);
            Contact.findByName({page: $scope.page, per_page:20, nombre:$scope.searchContact}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.contacts = result;
                Sharedcontact.setContactList($scope.contacts);
            });
        };

        $scope.$on('ContactChanged', function(event, contactList) {
            $scope.contacts = contactList;
        });

    });
