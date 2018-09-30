(function(){
  angular.module("fizzBuzzApp").controller("gameController",["$scope","gameService","$window",function($scope,gameService,$window){

    $scope.maxNum = null;
    $scope.minNum = 1;
    $scope.numRandom = null;

    $scope.getMaxNumber = function(){
      $scope.maxNum = gameService.getMaxNumber();
    }

    $scope.generateNumber = function(){
      $scope.numRandom = Math.floor(Math.random() * ($scope.maxNum - $scope.minNum + 1)) + $scope.minNum;
    }

    $scope.startGame = function(){
      //TODO
    }

  }]); //ends controller code
})(); //ends angular code here
