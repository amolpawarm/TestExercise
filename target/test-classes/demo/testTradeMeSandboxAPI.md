# Test Exercise for QA Engineer candidates

## The Exercise
Using the TradeMe Sandbox web site write automation code which does the following:

- Return how many named brands of used cars are available in the TradeMe UsedCars category.
- Check that the brand Kia exists and return the current number of Kia cars listed.
- Check that the brand Hispano Suiza does not exist.


### [get the many total number of named brands of used cars are available in the TradeMe UsedCars category](- "")

Given the TradeMe Sandbox API - __[https://api.trademe.co.nz/v1/Categories/UsedCars.json](- "#endpoint")__

When we make [GET call to the endpoint](- "getUsedCarsDetails(#endpoint)")

Then the response contains : __[ ](- "c:echo=getNumberOfNamedBrand()")__ number of used cars named brands.


### [verify brand Kia exists in the response](- "")

Given the TradeMe Sandbox API - __[https://api.trademe.co.nz/v1/Categories/UsedCars.json](- "#endpoint")__

When we make [GET call to the endpoint](- "getUsedCarsDetails(#endpoint)")

Then the response contains __[Kia](- "c:assert-true=verifyBrandExist(#TEXT)")__ brand


### [verify brand Hispano Suiza does not exists in the response](- "")

Given the TradeMe Sandbox API - __[https://api.trademe.co.nz/v1/Categories/UsedCars.json](- "#endpoint")__

When we make [GET call to the endpoint](- "getUsedCarsDetails(#endpoint)")

Then the response does not contain __[Hispano Suiza](- "c:assert-false=verifyBrandExist(#TEXT)")__ brand

<p>
	<span concordion:execute="#response=getResponsePrettyString()" />
    Response : <div concordion:echo="#response" />
</p> 

