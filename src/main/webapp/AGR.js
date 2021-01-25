var AGRwebapp = angular.module('AGRwebapp', ['ngRoute']);

AGRwebapp.config(function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl: 'home.html'
		}).when('/memberBio', {
			templateUrl: 'memberBio.html'
		}).when('/shows', {
			templateUrl: 'shows.html'
		}).when('/merch', {
			templateUrl: 'merch.html'
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
		$scope.dropDownContent = [];
		$scope.selectedModalItem = {
			itemId: selectedItem.itemId,
			itemName: selectedItem.itemName,
			itemPrice: selectedItem.itemPrice,
			itemDesc: selectedItem.itemDesc,
			itemImage: selectedItem.itemImage,
			hasVariant: selectedItem.hasVariant,
			variants: selectedItem.variants
		};
		console.log($scope.selectedModalItem);

		if ($scope.selectedModalItem.hasVariant == true) {
			document.getElementById('sizesOptions').style.visibility = 'visible';
		} else {
			document.getElementById('sizesOptions').style.visibility = 'hidden';
		}
	}


	$scope.addToCart = function() {
		$scope.itemCartId++;
		$scope.itemForShoppingCart = {
			tempId: $scope.itemCartId,
			itemName: $scope.selectedModalItem.itemName,
			itemPrice: $scope.selectedModalItem.itemPrice,
			selectedVariant: $scope.itemVariant
		}
		$scope.shoppingCart.push($scope.itemForShoppingCart);
		console.log($scope.shoppingCart);
	}

});


