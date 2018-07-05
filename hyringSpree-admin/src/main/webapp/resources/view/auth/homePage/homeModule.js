(function(){
	angular.module("homeModule",[]);
	angular.module("homeModule").config(function($routeProvider){
		 $routeProvider
		 .when("/homePage",{
			 templateUrl : "resources/view/auth/homePage/homePage.html",
			 controller  : "homeCtrl"
		 })
		 .otherwise({
			 redirectTo : "/homePage"
		 });
		
		 
	});
	
})();