The scope of the project

The Drugstore Management System is simulated in this dummy application. 
I implemented all CRUD operations for Address, Brand, Customer, Facility, Inventory, Orders, Product Type and Supplier. 
The Facility basically controls different drugstores. It incorporates the Address, Orders and Inventory. 
In order to create an item in Inventory, we need to send brandId, productTypeId, and SupplierId. 
After the successful creation of the item, the aforementioned item is saved with the current timestamp.
Every variable has its own set of validations.

The application allows you to perform a variety of tasks.
It is possible to:
Make a list of addresses in the same city, List all brands in some drugstore, Get a list of customers that are allergic to the same medicine, Get a list of verified customers, Count customers allergic to a specific drug, Get items with specific expiry date, Get a list of products of the same type, Make a list of items made by the same brand, Count items made by the same brand, Find suppliers that signed the contract on a specific date, Find suppliers who contract expires on a specific date, Get items of the same supplier, Count items from the same supplier, Find orders that were made on a specific date, and Make a list of orders made by the same customer.

The developer is assumed to have Java 11 or higher installed. 
Maven, git, docker, and docker-compose are also required. 
Keep in mind that you must meet the prerequisites listed above.

In order to start everything up, follow the next steps:
  1. git clone https://github.com/bavarac93/drugstore-ms 
     This will clone the latest version of the Drugstore Management System to a drugstore-ms folder.

  2. Simply cd to the root of the project and docker-compose up --detach. 
     Running docker compose script starts the postgres container in the background and leaves it running (it will pull the image if necessary).

  3. mvn clean install 
     This command is used to resolve dependencies that are listed in our pom.xml

  4. mvn spring-boot:run 
     This command runs the application.
     
Flyway scripts have been added for manual testing.

Examples: 

In order to create a brand we will hit http://localhost:8080/brand using HTTP POST method by sending the appropriate request body.
curl -X POST "http://localhost:8080/brand" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"brandDesc\": \"A German pharmaceutical company\", \"brandName\": \"Bayer\", \"email\": \"info@bayer.com\", \"phoneNumber\": \"+490123654\", \"website\": \"www.bayer.com\"}" 

The same will be repeated for the product type.
curl -X POST "http://localhost:8080/product_type" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"productType\": \"Medication\", \"productTypeDesc\": \"It is a requirement for a long and happy life.\"}"

Afterwards, we will create a supplier.
curl -X POST "http://localhost:8080/supplier" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"contractExpires\": \"2032-04-21 14:25:57\", \"contractSigned\": \"2022-04-21 14:25:57\", \"supplierDesc\": \"A French multinational supplier of medications and medical supplies\", \"supplierName\": \"Sanofi\"}"

The requirements have been met to create an item in the inventory.
curl -X POST "http://localhost:8080/inventory" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"brandId\": 212, \"description\": \"A multifunctional medication that is proven to reduce inflammation\", \"expiryDate\": \"2032-04-21T14:31:56.241Z\", \"itemName\": \"Paracetamol\", \"price\": 1, \"productTypeId\": 213, \"quantity\": 50, \"sku\": \"3874561291\", \"sold\": 200, \"supplierId\": 214}"


