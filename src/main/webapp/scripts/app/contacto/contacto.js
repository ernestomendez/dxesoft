/**
 * Created by ernesto on 4/18/15.
 */
'use strict';

angular.module('dxesoftApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('contacto', {
                abstract: true,
                parent: 'site'
            });
    });
