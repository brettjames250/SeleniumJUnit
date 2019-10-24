# brettjames-bjss-shorttechtest

## About

This test automation framework contains both UI and API tests, as part of the SDET Technical Test

- Test website - https://the-internet.herokuapp.com/ 
- Rest API - http://dummy.restapiexample.com/ .

## Usage

To run the tests from the IDE command line

```
mvn clean test
```

Extent Reports are generated after test execution, and can be viewed in the **ExtentReports** folder

## Future Improvements

- Although the basic TestNG framework suits this example, a Serenity BDD implementaion could be more efficient if the volume and complexity of tests increased. This would also provide more detailed reports.

