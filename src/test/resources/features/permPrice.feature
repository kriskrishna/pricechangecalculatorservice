Feature:  the user calls the Post endpoint of Price Change Instruction Write Service and Persist only the perm data to the Cassandra tables
Scenario Outline:  Post endpoint call of Price Change Instruction Write Service for the valid data

When the user makes a POST call to the permPriceChangeInstruction​​​​​​​ with "<URL>" from "<FilePath>" file
Then the user should see Response status code of "<StatusCode>" and response "<Message>"
Then verify Post data is persisted in cassandra database with "<Attribute>" and "<AttributeValue>" 

Examples:
              |FilePath|StatusCode|Message|URL|Attribute|AttributeValue|
              |src/test/resources/json-test-files/PricingRequestResponse.json|201|CREATED|http://localhost:8080/pricechangewriter/perm-instructions|departmentNumber|501|

Scenario Outline:  Post endpoint call of Price Change Instruction Write Service for the invalid inputs in request body like null, blank space, invalid datatype 

When the user makes a POST call to the permPriceChangeInstruction​​​​​​​ with "<URL>" from "<FilePath>" file with invalidd "<Attribute>" and "<AttributeValue>" 
Then the user should see Response status code of "<StatusCode>" and response "<Message>"

Examples:
          |FilePath|StatusCode|Message|URL|Attribute|AttributeValue|
            |src/test/resources/json-test-files/PricingRequestResponse.json|400|BAD_REQUEST|http://localhost:8080/pricechangewriter/perm-instructions|departmentNumber|null|            
            |src/test/resources/json-test-files/PricingRequestResponse.json|400|BAD_REQUEST|http://localhost:8080/pricechangewriter/perm-instructions|departmentNumber| |
             |src/test/resources/json-test-files/PricingRequestResponse.json|400|BAD_REQUEST|http://localhost:8080/pricechangewriter/perm-instructions|startDate|null|
            |src/test/resources/json-test-files/PricingRequestResponse.json|400|BAD_REQUEST|http://localhost:8080/pricechangewriter/perm-instructions|startDate| |
              |src/test/resources/json-test-files/PricingRequestResponse.json|400|BAD_REQUEST|http://localhost:8080/pricechangewriter/perm-instructions|newFirstTicket|ticketstring|            
              

Scenario Outline:  Post endpoint call of Price Change Instruction Write Service with updated valid inputs for primary keys and non-primary key attributes

When the user makes a POST call to the permPriceChangeInstruction​​​​​​​ with "<URL>" from "<FilePath>" file with new valid "<Attribute>" and "<AttributeValue>" 
Then the user should see Response status code of "<StatusCode>" and response "<Message>"


Examples:
             |FilePath|StatusCode|Message|URL|Attribute|AttributeValue|
           |src/test/resources/json-test-files/PricingRequestResponse.json|201|CREATED|http://localhost:8080/pricechangewriter/perm-instructions|StartDate|05/29/2019|
             |src/test/resources/json-test-files/PricingRequestResponse.json|201|CREATED|http://localhost:8080/pricechangewriter/perm-instructions|departmentNumber|805|
            |src/test/resources/json-test-files/PricingRequestResponse.json|201|CREATED|http://localhost:8080/pricechangewriter/perm-instructions|markStyleNumber|70184|
            |src/test/resources/json-test-files/PricingRequestResponse.json|201|CREATED|http://localhost:8080/pricechangewriter/perm-instructions|vendorNumber|6|
            |src/test/resources/json-test-files/PricingRequestResponse.json|201|CREATED|http://localhost:8080/pricechangewriter/perm-instructions|pricingEventID|6500|
              
        
Scenario Outline: Verify new records created and persisted in Cassandra database for Primary Key and Non-Primary Key

Then verify new created records is persisted in cassandra database with "<Attribute>" and "<AttributeValue>" 
Examples:
            |Attribute|AttributeValue|
			|markStyleNumber|70184|
			
Scenario Outline: Verify combination of mandatory primary keys of department number,vendor number, markstyle number
Given the user enters "<MandatoryAttributeValue1>" for "<MandatoryAttribute1>" and pass blank values for "<MandatoryAttribute2>" and "<MandatoryAttribute3>" from "<FilePath>" file for "<URL>"
Then the response message should return  "<errorMessage1>" and "<errorMessage2>" with "<StatusCode>"
Examples:
|StatusCode|URL|MandatoryAttributeValue1|MandatoryAttribute1|MandatoryAttribute2|MandatoryAttribute3|FilePath|errorMessage1|errorMessage2|
|400 BAD_REQUEST|http://localhost:8080/pricechangewriter/perm-instructions|5|vendorNumber|departmentNumber|markStyleNumber|src/test/resources/json-test-files/PricingRequestResponse.json|Mark Style Number is required field|Department number is required field|
|400 BAD_REQUEST|http://localhost:8080/pricechangewriter/perm-instructions|70999|markStyleNumber|departmentNumber|vendorNumber|src/test/resources/json-test-files/PricingRequestResponse.json|Department number is required field|Vendor Number is required field|
|400 BAD_REQUEST|http://localhost:8080/pricechangewriter/perm-instructions|401|departmentNumber|markStyleNumber|vendorNumber|src/test/resources/json-test-files/PricingRequestResponse.json|Mark Style Number is required field|Vendor Number is required field|

Scenario Outline: Verify combination of primary keys with an update of current Ticket
Given the user makes a post call with existing values for deptnum, vendornum,markstylenum as "<deptNumValue>", "<vendorNumValue>", "<markstyleNumValue>" and different value for current ticket as "<currTicketValue>" from "<FilePath>" file for "<URL>"
Then the existing record "<deptNumValue>","<vendorNumValue>", "<markStylenumValue>"  should be updated with new ticket "<currTicketValue>" in Cassandra and should see Response status code of "<StatusCode>" and response "<Message>"
Examples:
|FilePath|StatusCode|Message|URL|deptNum|deptNumValue|vendorNum|vendorNumValue|markStylenum|markstyleNumValue|currTicket|currTicketValue|
|src/test/resources/json-test-files/PricingRequestResponse.json|201|CREATED|http://localhost:8080/pricechangewriter/perm-instructions|departmentNumber|501|vendorNumber|3|markStyleNumber|70183|currentTicket|25|