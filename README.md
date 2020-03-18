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
    * note that this project is as simple as it could be and focused only on persistence layer, cross-cutting proper 
    approach (hexagonal) will be discussed elsewhere

## key annotations
* `@Inheritance`
    * default: `InheritanceType.SINGLE_TABLE`
    * specifies the inheritance strategy to be used for an entity class hierarchy
    * it is specified on the entity class that is the root of the entity class hierarchy
        
## MappedSuperclass
* is implemented in the domain model - without reflecting it in the database schema
* inheritance is visible in the domain model only, and each database table contains 
both the base class and the subclass properties
* is not mirrored at the database level, so it’s not possible to use polymorphic queries (fetching 
subclasses by their base class)
* key annotations
    * `@MappedSuperclass`
        * designates a class whose mapping information is applied to the entities that inherit from it
        * a mapped superclass has no separate table defined for it

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
    * create tag
        ```
        tagRepository.save(...)
      
        insert 
        into
            tag
            (version, name, id) 
        values
            (?, ?, ?)
        ```
    * find all tags
        ```
        tagRepository.findAll()
      
        select
            id
            version
            name
        from
            tag
        ```

## single table
* the domain model class hierarchy is materialized into a single table which contains entities 
belonging to different class types
* maps all subclasses to only one database table
* each subclass declares its own persistent properties
* if the `@Inheritance` annotation is not specified or if no inheritance type is specified for an entity
class hierarchy, the `SINGLE_TABLE` mapping strategy is used
* each subclass in a hierarchy must define a unique discriminator value, which is used to differentiate 
between rows belonging to separate subclass types
* when using polymorphic queries, only a single table is required to be scanned to fetch all associated 
subclass instances
* among all other inheritance alternatives, the single table strategy performs the best since it requires 
access to one table only
* because all subclass columns are stored in a single table, it’s not possible to use NOT NULL constraints 
anymore, so integrity checks must be moved either into the data access layer or enforced through CHECK or 
TRIGGER constraints
* key annotations
    * `@DiscriminatorColumn(name = "type")`
        * default name: DTYPE
        * default type: STRING
            * STRING, CHAR, INTEGER
    * `@DiscriminatorValue(value = "Rectangle")`
        * default: entity name
        
### example
* entities
    ```
    @Entity
    @DiscriminatorValue(value = "Circle")
    @Getter
    @Setter
    class Circle extends Shape {
    
        private double radius;
    }
    
    @Entity
    @DiscriminatorValue(value = "Rectangle")
    @Getter
    @Setter
    class Rectangle extends Shape {
    
        private double width;
    
        private double length;
    }
    
    @Entity
    @DiscriminatorColumn(name = "type")
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    class Shape {
    
        @Id
        @GeneratedValue
        private Long id;
    }
    ```
* database (tables)
    ```
    Name: SHAPE
    Columns: TYPE | ID | RADIUS | LENGTH | WIDTH
    ```
* queries
    * create circle
        ```
        shapeRepository.save(...)
      
        insert 
        into
            shape
            (radius, type, id) 
        values
            (?, 'Circle', ?)
        ```
    * create rectangle
        ```
        shapeRepository.save(...)
      
        insert 
        into
            shape
            (length, width, type, id) 
        values
            (?, ?, 'Rectangle', ?)
        ```
    * find all circles
        ```
        circleRepository.findAll()
      
        select
            id,
            radius 
        from
            shape 
        where
            type='Circle'
        ```
    * find all rectangles
        ```
        rectangleRepository.findAll()
      
        select
            id,
            length,
            width 
        from
            shape 
        where
            type='Rectangle'
        ```
    * find all shapes
        ```
        shapeRepository.findAll()
      
        select
            id,
            radius,
            length,
            width,
            type
        from
            shape
        ```
      
## joined table
* the base class and all the subclasses have their own database tables and fetching a subclass 
entity requires a join with the parent table as well
* inherited state is retrieved by joining with the table of the superclass
* each subclass must declare a table column holding the object identifier
* when using polymorphic queries, the base class table must be joined with all subclass tables 
to fetch every associated subclass instance
* polymorphic queries can use several JOINS which might affect performance when fetching a large number of entities
* key annotations
    * `@Inheritance(strategy = InheritanceType.JOINED)`
    * `@PrimaryKeyJoinColumns` * used to map composite foreign keys
        * default: columns are assumed to have the same names as the primary key columns of the primary table 
        of the superclass
        * `@PrimaryKeyJoinColumn` - specifies a primary key column that is used as a foreign key to join to 
        another table
    
### example
* entities
    ```
    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    @Getter
    @Setter
    class Animal {
    
        @Id
        @GeneratedValue
        long id;
    }
    
    @Entity
    @Getter
    @Setter
    class Pet extends Animal {
    
        private String name;
    }
    
    @Entity
    @Getter
    @Setter
    class Wild extends Animal {
    
        private boolean endangered;
    }
    ```
* database (tables)
    ```
    Name: ANIMAL
    Columns: ID
    
    Name: PET
    Columns: NAME, ID
    
    Name: WILD
    Columns: ENDANGERED | ID
    ```
* queries
    * create pet
        ```
        animalRepository.save(...)
      
        insert 
        into
            animal
            (id) 
        values
            (?)
        
        insert 
        into
            pet
            (name, id) 
        values
            (?, ?)
        ```
    * create wild
        ```
        animalRepository.save(...)
      
        insert 
        into
            animal
            (id) 
        values
            (?)
        
        insert 
        into
            wild
            (endangered, id) 
        values
            (?, ?)
        ```
    * find all pets
        ```
        petRepository.findAll()
      
        select
            id,
            name 
        from
            pet 
        inner join
            animal
                on pet.id=animal.id
        ```
    * find all wilds
        ```
        wildRepository.findAll()
      
        select
            id,
            endangered
        from
            wild 
        inner join
            animal
                on wild.id=animal.id
        
        ```
    * find all animals
        ```
        animalRepository.findAll()
      
        select
                animal.id as id1_0_,
                pet.name as name1_4_,
                wild.endangered as endanger1_7_,
                case 
                    when pet.id is not null then 1 
                    when wild.id is not null then 2 
                    when animal.id is not null then 0 
                end as clazz_ 
            from
                animal 
            left outer join
                pet 
                    on animal.id=pet.id 
            left outer join
                wild 
                    on animal.id=wild.id
        ```
## Table per class
* each subclass has its own table containing both the subclass and the base class properties
* each table defines all persistent states of the class, including the inherited 
* when using polymorphic queries, a UNION is required to fetch the base class table along with all subclass tables
* polymorphic queries require multiple UNION queries, so be aware of the performance implications of a large class 
hierarchy

### example
* entities
    ```
    @Entity
    @Getter
    @Setter
    class Employee extends Person {
    
        private int salary;
    }
    
    @Entity
    @Getter
    @Setter
    class Employer extends Person {
    
        private int budget;
    }
    
    @Entity
    @Getter
    @Setter
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    class Person {
    
        @Id
        @GeneratedValue
        Long id;
    }
    ```
* database (tables)
    ```
    Name: PERSON
    Columns: ID
    
    Name: EMPLOYER
    Columns: ID | BUDGET
    
    Name: EMPLOYEE
    Columns: ID | SALARY
    ```
* queries
    * create employer
        ```
        employerRepository.save(...)
        
        insert 
        into
            employer
            (budget, id) 
        values
            (?, ?)
        ```
    * create employee
        ```
        employeeRepository.save(...)
        
        insert 
            into
                employee
                (salary, id) 
            values
                (?, ?)
        ```
    * find all employees
        ```
        employeeRepository.findAll()
      
        select
            id as id1_3_,
            salary as salary1_1_ 
        from
            employee
        ```
    * find all employers
        ```
        employerRepository.findAll()
        
        select
            id,
            budget
        from
            employer
        ```
    * find all persons
        ```
        personRepository.findAll()
        
        select
                id,
                salary,
                budget,
                clazz_ 
            from
                ( select
                    id,
                    null as salary,
                    null as budget,
                    0 as clazz_ 
                from
                    person 
                union all 
                select
                    id,
                    salary,
                    null as budget,
                    1 as clazz_ 
                from
                    employee 
                union all 
                select
                    id,
                    null as salary,
                    budget,
                    2 as clazz_ 
                from
                    employer 
            )
        ```