/**
 * Created by ernesto on 4/18/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('ContactosController', function ($scope, Contact, ParseLinks, $state, $rootScope) {
        $scope.contacts = [];
        $scope.page = 1;
        $scope.loadAll = function() {
            //console.log("load all: ", headers);
            //console.log("load all: ", result);
            Contact.query({page: $scope.page, per_page: 20}, function(result, headers, getResponseHeaders) {
                console.log("headers: ", headers);
                console.log("headers(link): ", headers('link'));
                console.log("getResponseHeaders: ", getResponseHeaders);
                $scope.links = ParseLinks.parse(headers('link'));
                console.log("links: ", $scope.links);

                $scope.contacts = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };

        $scope.loadAll();
        $scope.contacto = '';
        $scope.selectedRow = null;

        $scope.setSelected = function (contact) {
            console.log("set selected");
            $scope.selectedContact = contact;
            $rootScope.selectedContact = contact;
            $state.go('detail', {id: contact.id});
        };

        $scope.isActive = function(contact) {
            return $scope.selectedContact === contact;
        };

        $scope.findBy = function() {
            console.log($scope.searchContact);
            Contact.findByName({page: $scope.page, per_page:20, nombre:$scope.searchContact}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.contacts = result;
            });
        }

    });
