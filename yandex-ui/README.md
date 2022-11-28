This maven module contains UI autotests for Yandex services.

Main goal of the tests is refresh knowledge about UI-testing and tick one of assessment goals.

For running the tests it is necessary to specify next properties (***src/main/resources/driver.properties***):
    
    > webdriver.chrome.driver
    > webdriver.gecko.driver
    > webdriver.opera.driver

The properties are used for getting specific WebDriver instance accord to property `browser.name`.

Also it is necessary to specify next properties (***src/test/resources/tests.properties***):

    > yandex.login.name
    > yandex.login.password

The properties are used for authorization on Yandex services.

==============================================

The command for test launching and report generating:

    > mvn clean test
    > mvn allure:serve
 