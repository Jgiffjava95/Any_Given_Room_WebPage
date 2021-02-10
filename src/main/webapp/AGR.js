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
	$scope.orderData = {};
	$scope.itemCartId = 0;
	$scope.itemOptions = { chosenVariant: "" };

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
		$scope.displayAddToCartAlert = false;
		$scope.selectedModalItem = {
			itemId: selectedItem.itemId,
			itemName: selectedItem.itemName,
			itemPrice: selectedItem.itemPrice,
			itemDesc: selectedItem.itemDesc,
			itemImage: selectedItem.itemImage,
			hasVariant: selectedItem.hasVariant,
			variants: selectedItem.variants
		};
	}


	$scope.addToCart = function() {
		$scope.itemCartId++;
		var isUnique = true;
		$scope.itemForShoppingCart = {
			tempId: $scope.itemCartId,
			itemName: $scope.selectedModalItem.itemName,
			itemPrice: $scope.selectedModalItem.itemPrice,
			itemImage: $scope.selectedModalItem.itemImage,
			itemVariant: $scope.itemOptions.chosenVariant,
			itemQuan: 1
		}

		if ($scope.shoppingCart.length == 0) {
			$scope.shoppingCart.push($scope.itemForShoppingCart);
			$scope.addToCartAlertFunction($scope.itemForShoppingCart.itemName, $scope.itemForShoppingCart.itemVariant);
		} else {
			for (i = 0; i < $scope.shoppingCart.length; i++) {
				if ($scope.shoppingCart[i].itemName == $scope.itemForShoppingCart.itemName &&
					$scope.shoppingCart[i].itemVariant == $scope.itemForShoppingCart.itemVariant) {
					$scope.shoppingCart[i].itemQuan++;
					isUnique = false;
				}
			}
			if (isUnique == true) {
				$scope.shoppingCart.push($scope.itemForShoppingCart);
				$scope.addToCartAlertFunction($scope.itemForShoppingCart.itemName, $scope.itemForShoppingCart.itemVariant);
			}
		}
		$scope.calcTotalPrice();
	}

	$scope.calcTotalPrice = function() {
		$scope.orderData.orderTotal = 0;
		for (i = 0; i < $scope.shoppingCart.length; i++) {
			console.log($scope.shoppingCart[i].itemPrice);
			var priceByQuantity = $scope.shoppingCart[i].itemPrice * $scope.shoppingCart[i].itemQuan;
			$scope.orderData.orderTotal += priceByQuantity;

		}
	}

	$scope.removeAndUpdateOrder = function(item) {
		$scope.shoppingCart.splice(item, 1);
		$scope.calcTotalPrice();
	}

	$scope.addToCartAlertFunction = function(itemName, itemVariant) {

		if (itemVariant == null) {
			$scope.itemForAddToCartAlert = itemName;
		} else {
			$scope.itemForAddToCartAlert = itemName + " " + itemVariant;
		}
		$scope.displayAddToCartAlert = true;
	}

});


