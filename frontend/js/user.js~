angular.module('myApp', [])
    .controller('MyCtrl', function($scope, $http) {
        $scope.addUser = function(user) {
            $http.put('/api/user', user).then(function(response) {
	    window.location.assign("../admin2.html")            
	});
        }
    });
