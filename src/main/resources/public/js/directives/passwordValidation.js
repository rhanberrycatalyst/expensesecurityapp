angular.module("expenseApp").directive("pwCheck", function(){
	
	//makes sure the password fits all criteria
	return{
		require: 'ngModel',
        link: function (scope, elem, attrs, model) {
            if (!attrs.pwCheck) {
                console.error('pwCheck expects a model as an argument!');
                return;
            }
            scope.$watch(attrs.pwCheck, function (value) {
                model.$setValidity('pwCheck', value === model.$viewValue);
            });
            model.$parsers.push(function (value) {
                var isValid = value === scope.$eval(attrs.pwCheck);
                model.$setValidity('pwCheck', isValid);
                return isValid ? value : undefined;
            });
        }
    };
});