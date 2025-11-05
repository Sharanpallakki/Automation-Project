Feature: Search the product on both Landing and offersPage
@place
  Scenario Outline: Search the product
    Given user landed on the landing page
    When user serach the short text <text> on the landing page and extract the product
    Then search the same short text <text> on offerspage
    And validate both Text on landingpage and offerspage

    Examples: 
      | text |
      | Bri  |
      | beet |
