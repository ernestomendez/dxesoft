/**
 * Created by ernesto on 5/6/15.
 */
'use strict';

angular.module('dxesoftApp')
    .service('contact_utils', function() {

        this.getPhoneTypeOptions = function(){
            return [{code: "home", name:"global.phonetypes.home"},
                {code: "personal", name:"global.phonetypes.personal"},
                {code: "work", name:"global.phonetypes.work"},
                {code: "other", name:"global.phonetypes.other"}
            ]
        };


        this.getEmailTypeOptions = function(){
            return [{code: "personal", name:"global.emailtypes.personal"},
                {code: "work", name:"global.emailtypes.work"},
                {code: "other", name:"global.emailtypes.other"}
            ]
        };


    });
