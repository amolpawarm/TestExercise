# Test Exercise for QA Engineer candidates

## The Exercise
Using the TradeMe Sandbox web site write automation code which does the following:

- Return how many named brands of used cars are available in the TradeMe UsedCars category.
- Check that the brand Kia exists and return the current number of Kia cars listed.
- Check that the brand Hispano Suiza does not exist.


### [Verify TradeMe Sandbox Website](- "")

Given the TradeMe Sandbox website - __[https://www.tmsandbox.co.nz/motors/used-cars](- "#url")__

When we launch the website in browser and [navigate to used category section](- "launchBrowserAndNavigateToUsedCars(#url)")

Then the page contains : __[ ](- "c:echo=getTotalNumberOfNamedBrandAvailable()")__ number of named brands.

And the brand __[Kia exists](- "c:assert-true=verifyKiaBrandExists()")__ with :  __[ ](- "c:echo=getKiaCurrentListing()")__ number of current listings

And the brand __[Hispano Suiza does not exists](- "c:assert-true=verifyHispanoSuizaBrandDoesNotExists()")__