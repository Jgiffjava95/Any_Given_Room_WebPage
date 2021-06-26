
const AGRwebapp = angular.module('AGRwebapp', ['ngRoute']);

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
		}).when('/tickets', {
			templateUrl: 'tickets.html'
		}).when('/contact', {
			templateUrl: 'contact.html'
		});
});

AGRwebapp.controller('AGRwebappcontroller', function($scope, $http) {
	
	getShowList();

	$scope.mailForm = {};
	$scope.shoppingCart = [];
	$scope.shoppingCartItemTempId = 0;
	$scope.orderData = {};
	$scope.itemCartId = 0;
	$scope.itemOptions = { chosenVariant: "" };

	$scope.subscribe = function() {

		$scope.jsonObject = angular.toJson($scope.mailForm, false);
		$http.post('/AGRwebapp/webapi/agrapi/sub', $scope.jsonObject)
			.then(
				function success(response) {
					console.log('return status: ' + response.data.response)
				},
				function error(response) {
					console.log('return status: ' + response.data.response);
				}
			);

	}

	$scope.getInventory = function() {
		$http.get('/AGRwebapp/webapi/agrapi/item')
			.then(
				function(response) {
					$scope.items = response.data;
				}
			);
	}

	function getShowList() {
		$http.get('/AGRwebapp/webapi/agrapi/show')
			.then(
				function(response) {
					$scope.shows = response.data;
					$scope.sortShowsForUpcomingShow();
				}
			);
	}

	$scope.sortShowsForUpcomingShow = function() {
		for (i = 0; i < $scope.shows.length; i++) {
			if ($scope.shows[i].upcoming == true) {
				$scope.showForHomePage = {
					showImage: $scope.shows[i].showImage,
					showLocation: $scope.shows[i].showLocation,
					entryPrice: $scope.shows[i].entryPrice,
					showDate: $scope.shows[i].showDate
				};
			}
		}
	}
});