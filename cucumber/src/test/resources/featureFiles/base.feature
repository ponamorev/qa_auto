Feature: Search on Yandex
  Scenario Outline: Search on Yandex by 'Java' keyword
    Given User navigates to "<website>"
    When User puts "<text>" to an input
    And User clicks Search Button
    Then Result page is reached
    And The first result has title "<title>"

    Examples:
    | website       | text | title          |
    | https://ya.ru | Java | Java \| Oracle |
