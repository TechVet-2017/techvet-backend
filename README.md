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


### Table names

ALL tables must be named in the singular form, NOT the plural. So CREATE TABLE owners is INCORRECT, while CREATE TABLE owner is CORRECT.

### Database Migrations

We will be using the Flyway Maven plugin to manage our database migrations.

**First of all, open the flyway.properties file and add your database's username and password. This file must not be commited.**

Any and all alterations made in the database must be saved in a migration file. Please follow the following instructions whenever creating a new migration:


1. Create your migration file in the folder src/main/resources/db/migration.
    * The file name **must** be named like VX.Y.Z__Migration_description.sql.
        * Please note it's a capital V.
        * Please note the first letter of the migration description is also capital.
        * Please note there are two underscores after the version number.
        * X is the Sprint number.
        * Y is the Use Case number.
        * Z is the migration number. The migration number starts with 1 and is incremented by the number of migrations created.
    * For instance, if you are working on the Use Case #3 of Sprint #1, and you need to create a new table to store Owners. Your migration file, located in src/main/resources/db/migration, would be named:
        * V1.3.1__Create_table_owner.sql
    * And if you need a new migration after that, say to create a Patient table, it would be named:
        * V.1.3.2__Create_table_patient.sql 
        
2. To run your migrations outside of Eclipse, open a terminal in the project folder and type: 
    * mvn flyway:migrate
3. To run your migrations in Eclipse:
    1. Right click on your project, Run As > Run Configurations.
    2. Select Maven Build, then click the New button located in the top left corner of the window.
    3. In Base directory, click Browse Workspace... and select the project.
    4. In Goals, type: flyway:migrate
    5. Click Apply, then Run.
    6. This run configuration will be saved, so you can directly run it through Run As > Run Configurations the next time you want to migrate your database.


After each merge, it will be necessary to clean your database (due to eventual versioning conflicts, that are sure to happen). To do that, follow the above steps, but run the command flyway:clean instead of flyway:migrate. Then, migrate normally.

Be patient, have faith, and good luck. And keep walking.
