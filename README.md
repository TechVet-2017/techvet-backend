# techvet-backend
Backend TechVet repository


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



Be patient, have faith, and good luck. And keep walking.
