angular.module('expenseApp').service('currentUserService', [function(){
    var user = {};
    
    function getCurrentUser(){
        return this.user;
    }

    function setCurrentUser(user){
        this.user = user;
    }
  

    function getAdmin() {
    	return false;
    }
    

    return {
        getCurrentUser : getCurrentUser,
        setCurrentUser : setCurrentUser,
        getAdmin : getAdmin
    };


}]);
