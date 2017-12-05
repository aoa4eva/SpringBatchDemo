# SpringBatchDemo1
## An enhanced Spring Batch Batch example from Spring Guides

This project builds on the example from https://spring.io/guides/gs/batch-processing/

It uses a csv file (1000 records generated by mockaroo.com of first and last names) as the source file. 

Note that the source file for this project is located in the /resources (i.e. the same location as application.properties)

A logger is used to indicate the status of the job. 

The destination is a MYSQL database. For each record, the data is converted to upper case and then stored. 

This example modifieds the spring batch processing guide as follows: 

1. Adds @Entity annotation to the Person object, so that data can be stored to the database
2. Adds a PersonRepository to establish a connection do the database
3. Adds a RepositoryWriterItem repoWriter method, which allows data that is read from the csv (using the reader method) to be saved to the database. 
4. In the repoWriter method, the an instance of the PersonRepository is defined, and the operation to be performed is selected by using the setMethodName() method. 

## To Run the application: 
1. Clone the project 
2. Create a database / schema called springbatchtest
3. Run the project