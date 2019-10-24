# brettjames-bjss-shorttechtest

## About

This test automation framework contains both UI and API tests, as part of the SDET Technical Test

- Test website - https://the-internet.herokuapp.com/ 
- REST API - http://dummy.restapiexample.com/ .

## Usage

To run the tests from the IDE command line

```
mvn clean test
```

Extent Reports are generated after test execution, and can be viewed in the **ExtentReports** folder

## Future Improvements

- Although the basic TestNG framework suits this example, a Serenity BDD implementaion could be more efficient if the volume and complexity of tests increased. This would also provide more detailed reports.
- Introducing BDD style scenarios with Cucumber would provide readable testcases for non technical personel in the origanosation.
- The REST API tests could be more effective by using test data from a DataProvider or an imported CSV file.

