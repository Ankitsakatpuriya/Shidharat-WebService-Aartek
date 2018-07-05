(function(){
	angular.module("forgetModule",[]);
	angular.module("forgetModule").config(function($routeProvider){
		 $routeProvider
		 .when("/forgetPassword",{
			 templateUrl : "resources/view/auth/forgetPassword/forgetPassword.html",
			 controller  : "forgetCtrl"
		 })
		 .otherwise({
			 redirectTo : "/"
		 });
		
		 
	});
	
})();