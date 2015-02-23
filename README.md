# This application allows us to manage usage information for a particular user.

## First run the scriptSQL.sql file: 
    From the command line, run the 'scriptSQL.sql' file as follows:
```
    >> source <path to the scriptSQL.sql file>/scriptSQL.sql 
```
This creates a database named 'UserUsage' and a table named 'User' in it with user = root and password = test

## Then run the insertSQL.sql file: 
    From the command line, run the 'scriptSQL.sql' file as follows:
```
    >> source <path to the insertSQL.sql file>/insertSQL.sql 
```
This inserts values into a database named 'UserUsage' and a table named 'User' in it with user = root and password = test

## Running UsageManager locally
```
	git clone https://github.com/DayleChettiar/UsageManager.git
	mvn tomcat7:run
```

You can then access UsageManager here: http://localhost:8080/UsageManager/

## Working with UsageManager in Eclipse
 Inside Eclipse
```
File -> Import -> Existing projects into workspace
```
