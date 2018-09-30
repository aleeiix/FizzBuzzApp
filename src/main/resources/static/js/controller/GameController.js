/**
* @name=App.js
* @author= Aleix Riba
* @version = 1.0
* @description = file that is the game controller
* @date= 2018-09-30
*/

(function(){
  angular.module("fizzBuzzApp").controller("gameController",["$scope","gameService","$window",function($scope,gameService,$window){

    //Variables Scope
    $scope.maxNum = null;
    $scope.minNum = 1;
    $scope.numRandom = null;
    $scope.finishGame = false;

    /**
    * @name= getMaxNumber()
    * @author= Aleix Riba
    * @version = 1.0
    * @description = function that communicates the services to know the maximum number and sets it in $ scope.maxNum
    * @date= 2018-09-30
    * @params= none
    * @return = none
    */
    $scope.getMaxNumber = function(){
      gameService.getMaxNumber().then(function success(response) {
        $scope.maxNum = response.data;
      }, function error(response) {
        console.log("Error in GameController -> getMaxNumber()");
      });
    }

    /**
    * @name= generateNumber()
    * @author= Aleix Riba
    * @version = 1.0
    * @description = function that generates a random number between 1 and the maximum number and sets it in $ scope.numRandom
    * @date= 2018-09-30
    * @params= none
    * @return = none
    */
    $scope.generateNumber = function(){
      $scope.numRandom = Math.floor(Math.random() * ($scope.maxNum - $scope.minNum + 1)) + $scope.minNum;
      $scope.finishGame = false;
    }

    /**
    * @name= startGame()
    * @author= Aleix Riba
    * @version = 1.0
    * @description = function that communicates the services to start the game
    * @date= 2018-09-30
    * @params= none
    * @return = none
    */
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
