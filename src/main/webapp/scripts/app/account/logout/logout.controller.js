'use strict';

angular.module('dxesoftApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
