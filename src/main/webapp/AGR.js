var AGRwebapp = angular.module('AGRwebapp', ['ngRoute']);

AGRwebapp.config(function($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl : 'home.html'
}).when('/memberBio', {
	templateUrl :'memberBio.html'
}).when('/shows', {
	templateUrl : 'shows.html'
}).when('/merch', {
	templateUrl : 'merch.html'
}).when('/merchItem', {
	templateUrl : 'merchItem.html'
	});
  });

AGRwebapp.controller('AGRwebappcontroller', function($scope, $http) {
	
	
	$scope.mailForm = {};
	$scope.shoppingCart = [];
	$scope.shoppingCartItemTempId = 0;
	
	$scope.subscribe = function() {
		
		$scope.jsonObject = angular.toJson($scope.mailForm, false);
		console.log('new email: ' + $scope.jsonObject);		
		
		$http.post('/AGRwebapp/webapi/agrapi/sub', $scope.jsonObject)
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
	
	$scope.getInventory = function() {
		$http.get('/AGRwebapp/webapi/agrapi')
  		.then(
				function(response) {
    				$scope.items = response.data;
  			}
		);
	}
	
	$scope.selectItemForItemModal = function(selectedItem) {
		$scope.selectedModalItem = {itemId: selectedItem.itemId, 
									itemName: selectedItem.itemName, 
									itemPrice: selectedItem.itemPrice, 
									itemDesc: selectedItem.itemDesc};
									console.log($scope.selectedModalItem);
	}
	
	$scope.addToCart = function() {
		$scope.shoppingCartItemTempId++;
		$scope.itemForShoppingCart = {tempId: $scope.shoppingCartItemTempId, 
									  itemName: $scope.selectedModalItem.itemName,
									  itemPrice: $scope.selectedModalItem.itemPrice};
		$scope.shoppingCart.push($scope.itemForShoppingCart);
		console.log($scope.shoppingCart);
	}
		

});


