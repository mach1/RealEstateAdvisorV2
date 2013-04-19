define([
  'angular',
  'ui.bootstrap'
], function(angular) {
  'use strict';

  // Define a module
  var result = angular.module('result', ['ui.bootstrap']);

  // Add a controller to result module
  result.controller('resultController', ['$scope', 'questionService', function($scope, questionService) {
    $scope.realEstates = [];
    questionService.getRealEstates().then(function(realEstates) {
      $scope.realEstates = realEstates;
    });
  }]);
  return result;
});