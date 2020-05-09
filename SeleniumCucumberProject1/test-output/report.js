$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Customers.feature");
formatter.feature({
  "name": "Customers",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Below steps are common steps for all the below scenarioes.",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launch chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User open url \"https://admin-demo.nopcommerce.com/login\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_open_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters Email as \"admin@yourstore.com\" and Password as \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_enters_Email_as_and_Password_as(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.click_on_Login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view Dashbord",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_can_view_Dashbord()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on customers Menu",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_click_on_customers_Menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on customer Menu Item",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.click_on_customer_Menu_Item()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add New Customer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Sanity"
    }
  ]
});
formatter.step({
  "name": "Click on Add New button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.click_on_Add_New_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view Add New Customer page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_can_view_Add_New_Customer_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter customer info",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_enter_customer_info()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.click_on_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user can view confirmation message \"The new customer has been added successfully.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_can_view_confirmation_message(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close browser",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.close_browser()"
});
formatter.result({
  "status": "passed"
});
});