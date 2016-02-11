angular.module('loginApp').service('currentUserService', function(){
    var user = {};
    
    function getCurrentUser(){
        return this.user;
    }

    function setCurrentUser(user){
        this.user = user;
    }

    return {
        getCurrentUser : getCurrentUser,
        setCurrentUser : setCurrentUser
    };


});
