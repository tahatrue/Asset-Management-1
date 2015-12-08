var app = angular.module('myApp', ['ngGrid']);
app.controller('MyCtrl', function($scope, $http) {
 
  $scope.gridOptions = {
    data: 'Employees',
    columnDefs: [{field:'eid', displayName:'Employee ID'}, {field:'ename', displayName:'Employee Name'}, {field:'email', displayName:'E-mail'}, {field:'age', displayName:'Age'}, {field:'sex', displayName:'Sex'}],
    enableSorting:true,	
    showGroupPanel: true,
    enableGridMenu:true,
    onRegisterApi: function (gridApi) {
            $scope.gridApi = gridApi;
    gridApi.rowEdit.on.saveRow($scope, $scope.saveRow)
}  
};

      $http.get('/api/user').then(function(response) {
         $scope.users= response.data;
      });      

});
