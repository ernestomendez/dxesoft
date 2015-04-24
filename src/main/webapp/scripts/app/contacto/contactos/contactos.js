/**
 * Created by ernesto on 4/18/15.
 */

'use strict';

angular.module('dxesoftApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('contactos', {
                parent: 'contacto',
                url: '/contactos',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'dxesoftApp.contactos.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/contacto/contactos/contactos.html',
                        controller: 'ContactosController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('contacto'); // ojo este debe estar definido en el controller
                        return $translate.refresh();
                    }]
                }
            })
            .state('detail', {
                url: '/contactos/:id',
                parent: 'contactos',
                //url: '',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'dxesoftApp.contactos.home.title'
                },
                onEnter: function($stateParams) {
                    console.log('slakjsdflkjasdf', $stateParams.id);
                },
                views: {
                    'detail': {
                        templateUrl: 'scripts/app/contacto/contactodetail/contacto-detail.html',
                        controller: 'Contacto-detailController'
                    }
                }
            })
    }
);
