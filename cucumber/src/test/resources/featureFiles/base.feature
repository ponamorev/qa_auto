Feature: Search on Yandex
  Scenario Outline: Search on Yandex by 'Java' keyword
    Given User navigates to "<website>"
    When User puts "<text>" to an input
    And User clicks Search Button
    Then Result page is reached

    Examples:
    | website       | text |
    | https://ya.ru | Java |
