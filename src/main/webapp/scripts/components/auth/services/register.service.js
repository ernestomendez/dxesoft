'use strict';

angular.module('dxesoftApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


