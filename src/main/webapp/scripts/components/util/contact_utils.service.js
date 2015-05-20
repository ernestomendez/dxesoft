/**
 * Created by ernesto on 5/6/15.
 */
'use strict';

angular.module('dxesoftApp')
    .service('contact_utils', function() {

        this.getPhoneTypeOptions = function() {
            return [{code: "home", name:"global.phonetypes.home"},
                {code: "personal", name:"global.phonetypes.personal"},
                {code: "work", name:"global.phonetypes.work"},
                {code: "other", name:"global.phonetypes.other"}
            ]
        };


        this.getEmailTypeOptions = function() {
            return [{code: "personal", name:"global.emailtypes.personal"},
                {code: "work", name:"global.emailtypes.work"},
                {code: "other", name:"global.emailtypes.other"}
            ]
        };


        this.getAddressTypeOptions = function() {
            return [{code: "primary", name:"global.addresstypes.primary"},
                {code: "delivery", name:"global.addresstypes.delivery"},
                {code: "invoice", name:"global.addresstypes.invoice"}
            ]
        };

        this.removeEmptyElementsFromList = function(lista, field) {
            for(var i = 0 ; i< lista.length; i++) {
                var obj = new Object();
                obj = lista[i];

                if(obj[field] === "") {
                    lista.splice(i,1);
                    i--;
                }
            }
        };


    });
