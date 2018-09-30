(function(){
  angular.module("fizzBuzzApp").controller("gameController",["$scope","gameService","$window",function($scope,gameService,$window){

    $scope.maxNum = null;
    $scope.minNum = 1;
    $scope.numRandom = null;
    $scope.finishGame = false;

    $scope.getMaxNumber = function(){
      gameService.getMaxNumber().then(function success(response) {
        $scope.maxNum = response.data;
      }, function error(response) {
        console.log("Error in GameController -> getMaxNumber()");
      });
    }

    $scope.generateNumber = function(){
      $scope.numRandom = Math.floor(Math.random() * ($scope.maxNum - $scope.minNum + 1)) + $scope.minNum;
      $scope.finishGame = false;
    }

    $scope.startGame = function(){
      if ($scope.numRandom != null) {
        gameService.startGame($scope.numRandom).then(function success(response) {
          if (response.data) {
            $scope.finishGame = true;
          } else {
            $scope.finishGame = false;
            console.log("Error in GameController -> startGame() return false");
          }
        }, function error(response) {
          $scope.finishGame = false;
          console.log("Error in GameController -> startGame()");
        });
      } else {
        $scope.finishGame = false;
        console.log("Error numRandom is null");
      }
    }

  }]); //ends controller code
})(); //ends angular code here
