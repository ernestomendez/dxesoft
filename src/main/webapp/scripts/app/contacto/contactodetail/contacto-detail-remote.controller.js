/**
 * Created by ernesto on 4/20/15.
 */
'use strict';

angular.module('dxesoftApp')
    .controller('Contacto-detail-remoteController', function ($scope, Contact, $stateParams) {
        $scope.get = function(id) {
            console.log("Contacto-detail-remoteController id: ", id);
            Contact.get({id: id}, function(result) {
                console.log("result: ", result);
                $scope.contactSelected = result;
            })
        };

        $scope.get($stateParams.id);

    });
