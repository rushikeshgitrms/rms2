Feature: To Test the individual functionality in calendar section.

  Scenario: Mandatory steps will execute Before each Scenario execution.
    Given User provide appropriate config to the system
    When User launch the browser
    And User put the valid instance
    And User put the valid credentials
    And User hit login button
    Then User confirm that User reach to homepage or not
    
  Scenario: To verify and validate add product to cart and checkout.
	When User click on Best Sellers button
	And User click on the first product appeared
	And User add that product to cart
	And User click on proceed to buy button
	Then User should land on checkout page
	And User should click on back navigation button
	
  Scenario: To verify and validate window switch.
	When User click on Amazon logo
	And User click on All button
	And User click on Mobiles, Computers
	And User click on Tablets
	And User click on blue color
	And User click on the product
	Then User should land on new window with that product details
	And User should be able add product to cart
	And User should be able to select parent window and click on audio button