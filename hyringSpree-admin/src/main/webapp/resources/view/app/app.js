(function(){
	'use strict';
	 var app = angular.module('hyringSpreeApp',['ngRoute','forgetModule','homeModule','signUpModule']);
	 app.config(function($routeProvider, $locationProvider, $httpProvider){
		 $routeProvider
		 .when("/login",{
			 templateUrl : "resources/view/auth/login/login.html",
			 controller  : "loginCtrl"
		 })
		 .when("/welcome",{
			 templateUrl : "resources/view/auth/login/welcome.html",
		 }).when("/signUp",{
			 templateUrl : "resources/view/auth/signUp/signUp.html",
			 controller  : "signUpCtrl"
		 })
		 .otherwise({
			 redirectTo : "/homePage"
		 });
		 $locationProvider.hashPrefix('');
	 })
	 
	 
})();