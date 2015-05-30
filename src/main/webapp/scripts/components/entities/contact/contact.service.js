'use strict';

angular.module('dxesoftApp')
    .factory('Contact', function ($resource) {
        return $resource('api/contacts/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                params: {id: '@id'},
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    if( data.birthDate) {
                        var birthDateFrom = data.birthDate.split("-");
                        data.birthDate = new Date(new Date(birthDateFrom[0], birthDateFrom[1] - 1, birthDateFrom[2]));
                    }
                    data.creationDate = new Date(data.creationDate);
                    console.log("data: ", data);
                    return data;
                }
            },
            'update': { method:'PUT' },
            'findByName': {
                method: 'GET',
                params: {nombre : '@nombre'},
                isArray: true
            },
            'post': {method:'POST'}
        });
    });
