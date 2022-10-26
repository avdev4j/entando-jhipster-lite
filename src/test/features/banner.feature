Feature: Banner

  Scenario: Should add banner Entando
    When I apply "banner-entando" module to default project without parameters
    Then I should have files in "src/main/resources"
      | banner.txt |
