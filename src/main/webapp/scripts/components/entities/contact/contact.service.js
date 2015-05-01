'use strict';

angular.module('dxesoftApp')
    .factory('Contact', function ($resource) {
        return $resource('api/contacts/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    var birthDateFrom = data.birthDate.split("-");
                    data.birthDate = new Date(new Date(birthDateFrom[0], birthDateFrom[1] - 1, birthDateFrom[2]));
                    data.creationDate = new Date(data.creationDate);
                    return data;
                }
            },
            'update': { method:'PUT' },
            'findByName': {
                method: 'GET',
                params: {nombre : '@nombre'},
                isArray: true
            }
        });
    });
