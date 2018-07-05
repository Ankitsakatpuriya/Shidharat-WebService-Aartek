(function(){
	'use strict';
	angular.module('hyringSpreeApp').controller('loginCtrl',["$http","$scope","$location","loginService","$timeout","forgetService",function($http,$scope,$location,loginService,$timeout,forgetService)
		{
	   
		$scope.user ={
						emailId : "",
						password : ""
		           }
		
		
		$scope.resetPassword = function(){
			console.log("inside forgetctrl resetFun");
			console.log($scope.user.emailId);
			console.log($scope.user.password);
			forgetService.forgetPassword($scope.user).then(function(data){
			});
			}
		$scope.login = function(state){
			console.log("inside login Ctrl function");
		
			console.log($scope.user.emailId);
			console.log($scope.user.password);
			
			loginService.login($scope.user).then(function(data){
				   console.log(data.data);
	               if(data.data == '200'){
	            	   $scope.statusMessage="true"; 
	            	   $location.path("/welcome");
	               }else if(data.data == '404'){
	            	   $scope.statusMessage="false"; 
	            	   $location.path("/login");
	               }
	               $timeout(function () {
						 $scope.statusMessage ="";
						 console.log("in time",$scope.statusMessage);
						 }, 3000);
				
			});
			}
		
		
		
	}]);
})();