 # READ ME

The used motor search URL mentioned the trademe API documentation website https://developer.trademe.co.nz/api-reference/search-methods/used-motors-search/
is different from the one menioned as corrected in the test exercise

1. URL in test exercise - https://api.trademe.co.nz/v1/Categories/UsedCars.json
2. URL on trademe API doco - https://api.trademe.co.nz/v1/Search/Motors/Used.json

The trademe URL requires authentication and gives "This API requires that you supply your application credentials" error

The corrected API works but the response does not contain all the information. The current listing info and lots of other info is missing.
The number of brand returned are also different than the what are displayed on website. Also the query params do not work

As a result I have performed the testing through both website using webdriver and 
also through the API (whatever information we could get) using restAssured.

Have used concordion as BDD tool to provide living documentation

src/test/java --> Fixture files
src/test/resources -- > Specification files

**To run the test suite run src/test/javaIndex.java as junit test**
 
 HTML report will be displayed in the console - (file://C:\Users\USER\AppData\Local\Temp\concordion\demo\Index.html)
 
 The webdriver test asssumes firefox installed on the machine. We can also run individual test indivifual fixtures -
 
 1. testTradeMeSandboxAPIFixture.java - API test 
 2. testTradeMeSandboxWebsiteFixture.java - Webdriver test