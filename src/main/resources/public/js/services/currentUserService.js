angular.module('expenseApp').service('currentUserService', [function(){
    var user = {};
    
    function getCurrentUser(){
        return this.user;
    }

    function setCurrentUser(user){
        this.user = user;
    }
<<<<<<< HEAD
 
=======
    
    function getAdmin() {
    	return true;
    }
    
>>>>>>> Sprint_2
    return {
        getCurrentUser : getCurrentUser,
        setCurrentUser : setCurrentUser,
        getAdmin : getAdmin
    };


}]);
