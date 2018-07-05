(function(){
	angular.module("signUpModule",[]);
	angular.module("signUpModule").config(function($routeProvider){
		 $routeProvider
		 .when("/signUp",{
			 templateUrl : "resources/view/auth/signUp/signUp.html",
			 controller  : "signUpCtrl"
		 })
		 
	});
	
})();