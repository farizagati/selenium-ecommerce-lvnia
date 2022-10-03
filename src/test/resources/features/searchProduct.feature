@search
Feature: Search product in Elevenia Website
  Scenario: I want to search a specific product and perform smoke testing functionality on cart and courier options
    Given Open website "https://www.elevenia.co.id"
    And Located on elevenia website
    Then I search for product terlaris in "Komputer" keyword
    Then I add "3" items to my shopping cart
    Then I go to cart section
    Then I modify the courier option
    Then I cancel to modify the courier option
    Then I cancel the product on my shopping cart