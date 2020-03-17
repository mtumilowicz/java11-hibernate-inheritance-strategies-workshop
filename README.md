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
    * note that this project is as simple as it could be, proper approach (hexagonal) is discussed here
    https://github.com/mtumilowicz/java13-spring-crud-http-methods-workshop

## MappedSuperclass
* is implemented in the domain model - without reflecting it in the database schema
* inheritance is visible in the domain model only, and each database table contains 
both the base class and the subclass properties
* is not mirrored at the database level, so it’s not possible to use polymorphic queries (fetching 
subclasses by their base class)

### example
* mapped superclass
    ```
    @MappedSuperclass
    @Getter
    class BaseEntity {
    
        @Id
        @GeneratedValue
        Long id;
    
        @Version
        Integer version;
    }
    ```
* entity
    ```
    @Entity
    @Getter
    @Setter
    class Tag extends BaseEntity {
    
        private String name;
    }
    ```
* database (tables)
    ```
    Name: TAG
    Columns: ID | VERSION | NAME  
    ```
* queries
    * find all

## Single table
* the domain model class hierarchy is materialized into a single table which contains entities 
belonging to different class types
* maps all subclasses to only one database table
* each subclass declares its own persistent properties
* is used by JPA by default when omitting an explicit inheritance strategy (e.g. `@Inheritance`)
* each subclass in a hierarchy must define a unique discriminator value, which is used to differentiate 
between rows belonging to separate subclass types
* when using polymorphic queries, only a single table is required to be scanned to fetch all associated 
subclass instances
* among all other inheritance alternatives, the single table strategy performs the best since it requires 
access to one table only
* because all subclass columns are stored in a single table, it’s not possible to use NOT NULL constraints 
anymore, so integrity checks must be moved either into the data access layer or enforced through CHECK or 
TRIGGER constraints

## Joined table
* the base class and all the subclasses have their own database tables and fetching a subclass 
entity requires a join with the parent table as well
* inherited state is retrieved by joining with the table of the superclass
* each subclass must declare a table column holding the object identifier
* when using polymorphic queries, the base class table must be joined with all subclass tables 
to fetch every associated subclass instance
* polymorphic queries can use several JOINS which might affect performance when fetching a large number of entities

## Table per class
* each subclass has its own table containing both the subclass and the base class properties
* each table defines all persistent states of the class, including the inherited 
* when using polymorphic queries, a UNION is required to fetch the base class table along with all subclass tables
* polymorphic queries require multiple UNION queries, so be aware of the performance implications of a large class hierarchy