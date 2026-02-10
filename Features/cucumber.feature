Feature: Test Calculator
    Scenario: Add tow numbers
        Given I have a calculator
        When I add 2 and 3
        Then The result should be 5