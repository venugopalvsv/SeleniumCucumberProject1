Feature: Customers

Background: Below steps are common steps for all the below scenarioes.

	Given User launch chrome browser
	When User open url "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashbord
	When User click on customers Menu
	And Click on customer Menu Item

@Sanity
Scenario: Add New Customer

	And Click on Add New button
	Then User can view Add New Customer page
	When User enter customer info
	And click on save button
	Then user can view confirmation message "The new customer has been added successfully."
	And Close browser
	
@Regression
Scenario: Search customer by EmailID

	And Enter customer Email
	When Click on Search Button
	Then User should found Email in the search table
	And Close browser 

@Regression	
Scenario: Search customer by Name

	And Enter customer FirstName
	And Enter customer LastName
	When Click on Search Button
	Then User should found Name in the search table
	And Close browser
	