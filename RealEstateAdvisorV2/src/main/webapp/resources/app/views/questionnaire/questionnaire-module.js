define([
  'angular',
  'ui.bootstrap'
], function(angular) {
  'use strict';

  // Define a module
  var questionnaire = angular.module('questionnaire', ['ui.bootstrap']);

  // Add a controller to questionnaire module
  questionnaire.controller('questionnaireController', ['$scope', '$location', 'questionService', function($scope, $location, questionService) {
    if ($location.path() === '') {
      $location.path('0');
    }
    $scope.$watch(function() {
      return $location.path();
    }, function() {
      $scope.currentQuestion = questionService.getQuestionById($scope.getStepId());
    });
    $scope.next = function() {

    };

    $scope.getStepId = function() {
      return parseInt($location.path().split('/')[1], 10);
    };

    $scope.getQuestionId = function() {
      return $scope.getStepId() + 1;
    };

    $scope.getNextStepId = function() {
      return $scope.getStepId() + 1;
    };

    $scope.getPreviousStepId = function() {
      return $scope.getStepId() - 1;
    };

    $scope.isFirstQuestion = function() {
      return $scope.getStepId() === 0;
    };

    $scope.isLastQuestion = function() {
      return ($scope.getStepId() + 1) === questionService.getQuestionCount();
    };

    $scope.currentQuestion = questionService.getQuestions()[$scope.getStepId()];
  }]);

  questionnaire.directive('questionnaire', function() {
    return {
        replace: true,
        restrict: 'E',
        controller: 'questionnaireController',
        templateUrl: 'app/views/questionnaire/questionnaire-partial.html'
    };
  });

  questionnaire.factory('questionService', function() {
    var questions = [
      {
        question: 'Lähimad naabrid peaksid asuma...',
        answers: ['Samas majas', 'Paarisaja meetri raadiuses', 'Kaugemal kui 1km'],
        selected: 0
      },
      {
        question: 'Meri...',
        answers: ['Peaks paistma aknast', 'Peaks olema jalutuskäigu kaugusel', 'Mere lähedus pole oluline'],
        selected: 0
      },
      {
        question: 'Kodu otsiva pere suurus on...',
        answers: ['1 liige', '2-4 liiget', '5 või rohkem liiget'],
        selected: 0
      }
    ];
    return {
      getQuestions: function() {
        return questions;
      },
      getQuestionCount: function() {
        return questions.length;
      },
      getQuestionById: function(id) {
        return questions[id];
      }
    };
  });

  return questionnaire;
});