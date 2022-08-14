angular.module('app', []).controller('indexController', function($scope, $http){
    const contextPath = "http://localhost:8081/app";

    $scope.fillTable = function() {
        $http.get(contextPath + '/api/v1/products')
        .then(function(response){
            $scope.ProductsList = response.data;
        });
        
    };

    $scope.submitCreateNewProduct = function(){
        $http.post(contextPath + '/api/v1/products/', $scope.newProduct)
        .then(function(response){
            $scope.fillTable();
        });
    }

    // $scope.addToCartFunction = function(product){
    //     $http({
    //         url: contextPath + '/api/v1/cart/add' + product.id,
    //         method: "GET"
    //     }).then(function(response){
    //         console.log('added');
    //     });
    // }

    $scope.deleteProductById = function(productId){
        $http({
            url: contextPath + '/api/v1/products/' + productId,
            method: "DELETE"
        }).then(function(response){
            $scope.fillTable();
        });
    }

    $scope.fillTable();
});