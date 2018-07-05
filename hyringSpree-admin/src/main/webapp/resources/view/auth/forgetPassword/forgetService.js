(function(){
	'use strict';
	angular.module("forgetModule").factory("forgetService",function($q,$http){
		var obj ={};
		obj.forgetPassword=function(email){
			console.log("inside forget service");
			console.log(email);
			var deferred = $q.defer();
			var config = {
					headers : {
						'Content-Type' : 'application/json'
					}
			};
			var data=angular.toJson(email);
			$http.post('forgetPassword', data ,config).then(function(data ,status ,config){
				deferred.resolve(data);
			},function(data, status, config){
				deferred.reject();
			})
			return deferred.promise;
		}
		console.log(obj);
		return obj ;
		
	});

})();		

console.log("end of forgetservice");
