var app = angular.module("geektic", ['ngRoute']);

app.config(['$routeProvider',
                   function($routeProvider) {
                     $routeProvider.
                       when('/search', {
                         templateUrl: 'view/search_geek.html',
                         controller: 'GeekSearchCtrl'
                       }).
                       when('/geeks', {
                         templateUrl: 'view/list_geek.html',
                         controller: 'GeekListCtrl'
                       }).
                       when('/geeks/:id', {
                         templateUrl: 'view/detail_geek.html',
                         controller: 'GeekDetailCtrl'
                       }).
                       otherwise({
                    	   redirectTo: '/geeks'
                       });
                   }]);

app.controller('GeekListCtrl', ['$scope', '$http',
   function ($scope, $http) {
	$http.get('/geeks').success(function(showGeek) {
        $scope.Geeks = showGeek;
    });
}]);

app.controller('GeekDetailCtrl', ['$scope','$http','$routeParams',
   function($scope,$http,$routeParams) {
	$http.get('/geeks/'+$routeParams.id).success(function(geek) {
        $scope.geek = geek;
    });
}]);

app.controller('GeekSearchCtrl', ['$scope', '$http',
    function ($scope, $http) {
 	$http.get('/centre-interet').success(function(interets) {
         $scope.interets = interets;
     });
}]);