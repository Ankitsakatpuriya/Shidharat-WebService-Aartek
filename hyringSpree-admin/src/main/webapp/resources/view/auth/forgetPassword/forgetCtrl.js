
console.log("forgetctrl");
		(function(){
	
	angular.module("forgetModule").controller("forgetCtrl",['$scope','forgetService',function($scope,forgetService){
				$scope.email = {
				                emailId: ""
					          }
				console.log($scope.email.emailId);
		$scope.resetpassword = function(){
					console.log("inside forgetctrl resetFun");
					console.log($scope.email.emailId);
					forgetService.forgetPassword($scope.email).then(function(data){
					});
					}
		
		
	}]);
		})();

		console.log("end of forgetctrl");

