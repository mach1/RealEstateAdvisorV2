define([
  'angular'
], function(angular) {
  'use strict';

  // Define a module
  var app = angular.module('app', []);
  app.config(function($locationProvider, $routeProvider) {
    $routeProvider
      .when('/questions', {
        templateUrl: 'app/partials/questions.html',
        controller: 'questionnaireController',
        reloadOnSearch: false
      })
      .when('/questions/:id', {
        templateUrl: 'app/partials/questions.html',
        controller: 'questionnaireController',
        reloadOnSearch: false
      })
      .when('/result', {
        templateUrl: 'app/partials/result.html',
        controller: 'resultController'
      })
      .otherwise({ redirectTo: '/questions' });
  });

  return app;
});