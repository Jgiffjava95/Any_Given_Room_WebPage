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
});
  });

AGRwebapp.controller('AGRwebappcontroller', function($scope, $http) {
	
	
	$scope.mailForm = {};
	$scope.shoppingCart = [];
	$scope.shoppingCartItemTempId = 0;
	$scope.selectedOptionSize = "";
	
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
		$scope.selectedModalItem = {itemId: selectedItem.itemId, 
									itemName: selectedItem.itemName, 
									itemPrice: selectedItem.itemPrice, 
									itemDesc: selectedItem.itemDesc,
									hasVariant: selectedItem.hasVariant,
									hasXS: selectedItem.hasXS,
									hasS: selectedItem.hasS,
									hasM: selectedItem.hasM,
									hasL: selectedItem.hasL,
									hasXL: selectedItem.hasXL};
									console.log($scope.selectedModalItem);
									
		if ($scope.selectedModalItem.hasVariant == true) {
			document.getElementById("sizesOptions").style.visibility = "visible";
			if ($scope.selectedModalItem.hasXS == true) {
				$scope.dropDownContent.push("XS");
			}
			if ($scope.selectedModalItem.hasS == true) {
				$scope.dropDownContent.push("S");
			}
			if ($scope.selectedModalItem.hasM == true) {
				$scope.dropDownContent.push("M");
			}
			if ($scope.selectedModalItem.hasL == true) {
				$scope.dropDownContent.push("L");
			}
			if ($scope.selectedModalItem.hasXL == true) {
				$scope.dropDownContent.push("XL");
			}
						
		} else {
			document.getElementById("sizesOptions").style.visibility = "hidden";
		}
	}
	
	$scope.addToCart = function() {
		$scope.shoppingCartItemTempId++;
		$scope.itemForShoppingCart = {tempId: $scope.shoppingCartItemTempId, 
									  itemName: $scope.selectedModalItem.itemName,
									  itemPrice: $scope.selectedModalItem.itemPrice,
								      selectedOptionSize: $scope.selectedOptionSize}
		$scope.shoppingCart.push($scope.itemForShoppingCart);
		console.log($scope.shoppingCart);
	}
		

});


