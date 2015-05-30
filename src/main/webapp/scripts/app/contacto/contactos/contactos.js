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
                onEnter: function($stateParams) {
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
            .state('addContact', {
                parent: 'detail',
                //url: '/contacto/',
                params: {'edit': false},
                data: {
                    roles: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$modal', '$resource', function($stateParams, $state, $modal) {
                    $modal.open({
                        size:'lg',
                        templateUrl: 'scripts/app/contacto/contactoForm/contacto-form.html',
                        resolve: {
                            translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                                $translatePartialLoader.addPart('contacto'); // ojo este debe estar definido en el controller
                                return $translate.refresh();
                            }]
                        },
                        controller: 'Contacto-formController'
                    }).result.finally(function() {
                            console.log("add contact modal finally")
                        });
                }]
            })
            .state('detailContact', {
                url: '/:id',
                parent: 'contactos',
                params: {'id': null},
                data: {
                    roles: ['ROLE_USER']
                },
                onEnter: function($stateParams) {
                },
                views: {
                    'detail': {
                        templateUrl: 'scripts/app/contacto/contactodetail/contacto-detail.html',
                        controller: 'Contacto-detail-remoteController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('contacto'); // ojo este debe estar definido en el controller
                        return $translate.refresh();
                    }]
                }
            })
            .state('editContact', {
                parent: 'detail',
                url: '/:id',
                params: {'edit': true},
                data: {
                    roles: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$modal', '$resource', function($stateParams, $state, $modal) {
                    $modal.open({
                        size:'lg',
                        templateUrl: 'scripts/app/contacto/contactoForm/contacto-form.html',
                        resolve: {
                            translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                                $translatePartialLoader.addPart('contacto'); // ojo este debe estar definido en el controller
                                return $translate.refresh();
                            }]
                        },
                        controller: 'Contacto-formController'
                    }).result.finally(function() {
                            console.log("edit contact modal finally")
                        });
                }]
            })
    }
);
