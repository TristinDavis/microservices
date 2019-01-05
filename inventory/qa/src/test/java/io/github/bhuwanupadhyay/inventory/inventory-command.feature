Feature: payment service

  Background:
    * url 'http://localhost:9000/inventory/products'

  Scenario: create product
    Given request { name: 'Product Name' }
    When method post
    Then status 200