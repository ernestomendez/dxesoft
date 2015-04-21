/**
 * Created by ernesto on 4/18/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('ContactosController', function ($scope, Contact, ParseLinks) {
        $scope.contacts = [];
        $scope.page = 1;
        $scope.loadAll = function() {
            console.log("contactoscontroller.loadall");
            Contact.query({page: $scope.page, per_page: 20}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.contacts = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };

        $scope.loadAll();
        $scope.contacto = '';
    });