(function(){
	'use strict';
	angular.module('hyringSpreeApp').factory('loginService',function($http, $q){
		var obj = {};
		
		obj.login = function(user){
			console.log("Inside login sercvice");
			var deferred = $q.defer();
			var config = {
					headers : {
						'Content-Type' : 'application/json'
					}
			};
			var data = angular.toJson(user);
			
			$http.post('login', data ,config).then(function(data ,status ,config){
				console.log(".....true.....")
				console.log(data);
				deferred.resolve(data);
			},function(data, status, config){
				deferred.reject();
			})
			return deferred.promise;
			
		}
		return obj;
	});
})();