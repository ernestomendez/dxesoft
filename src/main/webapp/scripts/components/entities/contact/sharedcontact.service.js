/**
 * Created by ernesto on 5/27/15.
 */
'use strict';

angular.module('dxesoftApp')
    .service('Sharedcontact', function($rootScope) {
        var contact = {};

        var contactList = [];

        return {
            setContact: function(value) {
                contact = value;
                console.log("SharedContactService -> setContact: ", contact);
            },
            getContact: function() {
                return contact;
            },
            updateContact: function(value) {
                contact = value;
            },
            setContactList: function(values) {
                contactList = values;
            },
            updateContactList: function(value) {
                console.log("Sharedcontact->updateContactList.value: ", value);
                for (var i = 0; contactList.length; i++) {
                    if (contactList[i].id == value.id) {
                        contactList[i] = angular.copy(value);
                        $rootScope.$broadcast('ContactChanged', contactList);
                        break;
                    }
                }
            }
        };
    });
