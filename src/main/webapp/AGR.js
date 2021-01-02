var AGRwebapp = angular.module("AGRwebapp", ["ngRoute"]);

AGRwebapp.config(function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "home.html"
}).when("/memberBio", {
	templateUrl : "memberBio.html"
}).when("/shows", {
	templateUrl : "shows.html"
}).when("/merch", {
	templateUrl : "merch.html"
	});
  });

AGRwebapp.controller("AGRwebappcontroller", function($scope, $http) {
	
	$scope.mailForm = {};
	
	$scope.subscribe = function() {
		
		$scope.jsonObject = angular.toJson($scope.mailForm, false);
		console.log('new email: ' + $scope.jsonObject);		
		
		$http.post("/AGRwebapp/webapi/agrapi/sub", $scope.jsonObject)
		.then(
				function success(response) {	
					console.log('status: ' + response.status);
					$scope.successResponse = response.data;
					console.log($scope.successResponse);
				},
				function error(response) {
					console.log('error, return status: ' + response.status);
				}
		);
		
	}
		

});


