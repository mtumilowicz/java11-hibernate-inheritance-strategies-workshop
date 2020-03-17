# java11-hibernate-inheritance-strategies-workshop

* reference
    * https://www.baeldung.com/hibernate-inheritance
    * https://memorynotfound.com/hibernate-jpa-single-table-inheritance-example/
    * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#entity-inheritance

## preface
* goals of this workshop:
    * introduce inheritance in hibernate:
        * single table
        * joined table
        * table per class
        * mapped superclass

## MappedSuperclass
* inheritance is implemented in the domain model only without reflecting it in the database schema

## Single table
* the domain model class hierarchy is materialized into a single table which contains entities 
belonging to different class types

## Joined table
* the base class and all the subclasses have their own database tables and fetching a subclass 
entity requires a join with the parent table as well

## Table per class
* each subclass has its own table containing both the subclass and the base class properties