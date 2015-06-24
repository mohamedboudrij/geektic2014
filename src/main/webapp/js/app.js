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
                       when('/audit/:id', {
                           templateUrl: 'view/detail_geek_audit.html',
                           controller: 'GeekAuditCtrl'
                         }).
                         when('/result-search', {
                             templateUrl: 'view/list_geek.html',
                             controller: 'ResultSearchCtrl'
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
        $scope.interets = geek.listOfInteret;
    });
}]);

app.controller('GeekSearchCtrl', ['$scope', '$http','$location',
    function ($scope, $http, $location) {
 	$http.get('/centre-interet').success(function(interets) {
         $scope.interets = interets;
     });
 	$scope.criteria = {};
 	$scope.search = function(){
 		$location.url("/result-search?sexe="+$scope.criteria.sexe+"&interet="+$scope.criteria.interet);
    }
}]);

app.controller('ResultSearchCtrl', ['$scope', '$http','$location',
	function ($scope, $http,$location) {
	$http.get('/result-search',{params: $location.search()}).success(function(showGeek) {
	         $scope.Geeks = showGeek;
	     });
 }]);
/*
app.controller('GeekAuditCtrl', ['$scope','$http','$routeParams',
  function($scope,$http,$routeParams) {
	$http.get('/audit/'+$routeParams.id).success(function(audit) {
           $scope.audits = audit;
       });
}]);*/