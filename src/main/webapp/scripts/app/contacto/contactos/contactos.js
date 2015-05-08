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
                    console.log('contactos on enter', $stateParams.id);
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
                    console.log('detail on enter', $stateParams.id);
                },
                views: {
                    'detail': {
                        templateUrl: 'scripts/app/contacto/contactodetail/contacto-detail.html',
                        controller: 'Contacto-detailController'
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
                //url: '/contactos/:id',
                parent: 'detail',
                //url: '',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'dxesoftApp.contactos.home.title'
                },
                onEnter: ['$stateParams', '$state', '$modal', '$resource', function($stateParams, $state, $modal) {
                    console.log('on enter', $stateParams);
                    $modal.open({
                        templateUrl: 'scripts/app/contacto/contactoForm/contacto-form.html',
                        resolve: {
                            translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                                $translatePartialLoader.addPart('contacto'); // ojo este debe estar definido en el controller
                                return $translate.refresh();
                            }]
                        },
                        controller: 'Contacto-formController'

                    }).result.finally(function() {
                            $state.go('^');
                            console.log("modal finally")
                        });
                }]
            })
    }
);
