# techvet-backend
Backend TechVet repository

[![Build Status](https://travis-ci.org/TechVet-2017/techvet-backend.svg?branch=development)](https://travis-ci.org/TechVet-2017/techvet-backend)

## Instructions for Development Team:

Please follow the following instructions carefully. Any mistakes will not be forgiven.

Clone the repository.

**git clone https://github.com/luizguilherme5/techvet-backend**

In Eclispe, select File > Import > Existing Maven Project. Select the cloned project. 
Eclipse will import the project and download the maven dependencies. It may take a while.

Now, we have three main packages that MUST be used.

### Basics

Do NOT create a new java project. If you need a new java class, type CTRL + N and select Class.
In the following screen, you need only to type the Name of the java class and the package. 

For the package, follow the guides below:

### Bean

If you are creating a BEAN, the package of the java class should be:

**br.com.bovdog.bean**

### Service
If you are creating a SERVICE, the package of the java class should be:

**br.com.bovdog.service**

### DAO
If you are creating a DAO, the package of the java class should be:

**br.com.bovdog.dao**

### Others
Now, if you are creating a class that doesn't fit in neither DAO, SERVICE or BEAN, fell free to create a new package in the form of:

**br.com.bovdog.yourpackage**

Example: br.com.bovdog.util.

## Database


You must manually create your database, and it must be called 'techvet'.

### Hibernate

We are now using Hibernate! It automatically creates your tables and columns according to your beans. It has simpler methods to CRUD operations. It is easier to use and less repetitive than JDBC. It makes you coffee every morning!

### Database Migrations

We will no longer be using the Flyway Maven plugin. We do not need migrations anymore. It was fun while it lasted.

### Logging the System with Logs4j

By default we will use logs4j as a tool to log the system. 
These are the specifications and how we're going to use it.
**IMPORTANT** Maven clean install before use as the pom.xml is updated.

#### Configuration File

The configuration file log4j.properties is under `src/main/resources` give it a look and understand it.
The line `log4j.rootLogger=TRACE, stdout, file` shows what level of logs will be shown. With `TRACE` all levels will appear in the console and the file. If we change that to `ERROR`, only `ERROR` and `FATAL` will appear.

##### Log file location

As you can see in the .properties the logs are stored in `./logs/TechVet.log` the `.` indicates the root folder of Unix/debian systems.

##### Log Levels

There are some levels of logs as we can see in .properties file:
**TRACE** Shows all actions of the system:
	e.g. 07-04-2017 18:55:28 TRACE Loader:1003 - Done processing result set (2 rows)

**DEBUG** Shows the actions of the system in debug level:
	e.g. 07-04-2017 18:55:28 DEBUG LogicalConnectionManagedImpl:154 - Initiating JDBC connection release from afterTransaction

**INFO** Infos are programmed to appear in the log files.

**WARN** Warns are programmed to appear and sometimes the system itself sends the warning.

**ERROR** Errors are programmed and sometimes the system itself sends the errors.

**FATAL** Fatal are programmed to appear in logs.

##### Usage
In order to use the logger in your .java file you need to first import the logger with:
`import org.apache.log4j.Logger;`

After that you need to instantiate a logger object with:
`final static Logger logger = Logger.getLogger(yourclassname.class);`

We can set the log locations with the following codes:

**TRACE:**
`logger.trace("this is trace");`

**DEBUG** checking if the debug level is on:
`if(logger.isDebugEnabled()){
	logger.debug("This is debug");
}`

**INFO** checking if the info level is on:
`if(logger.isInfoEnabled()){
	logger.info("This is info");
}`

**WARN**
`logger.warn("This is warn");`

**ERROR**
`logger.error("This is error");`

**FATAL**
`logger.fatal("This is fatal");`

Values of variables can be showed in the logger too, just use the `+ variable` and the value will appear in the file.
This end the Logger Section.

Be patient, have faith, and good luck. And keep walking.
