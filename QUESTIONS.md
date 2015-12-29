### Questions

1. why does int default to 0 and Integer (boxed) default to null ?

2. @NotNull annotation  
   can use javax @NotNull annotation with spring, or guice also i think. 
   but which one to use ?
   http://stackoverflow.com/questions/4963300/which-notnull-java-annotation-should-i-use
   https://jcp.org/en/jsr/detail?id=305
  
3. is there a good java REPL ?
   can always put a debugger in Intellj and evaluate any code!
   how does Intellij do that ? any product it uses like
   http://www.crashub.org
   http://www.beanshell.org/intro.html
   https://code.google.com/p/cliche/
  
   JEP 222: jshell: The Java Shell (Read-Eval-Print Loop)
   http://openjdk.java.net/jeps/222
  
4. Intellij has a wizard for generating equals and hashCode
  
   - accept subclasses
   - use getters
   - fields to include in equals
   - fields to include in hashCode
   - select not-null fields so that null check can be skipped
  
   any way to declaratively encode these decisions, rather than generating code ?
   maybe a DSL
  
   also there is a contract between equals and hashCode. 
  
   The general contract of hashCode is:  
   1. equal objects as per the `Object.equals` method, should have the same hashCode  
   2. if Object.equals is not changed by eg. mutating object,  
      then the hashCode method must consistently return the same value.  
      also it should be consistent across multiple calls ie. it is a pure function  
   3. two objects which are unqual as per `Object.equals` then `hashCode` may return the same value  
      but for hashtables it is better for performance if, objects which are not equal have the same hashCode  
      so for eq. it is valid if hashCode is hardcoded to 1 for all objects,  
      as two objects which are equal, will have the same hashcode  
      but hashtables will not be performant  
      btw what will be the speed difference if we hardcode Object.hashCode to be 1 for all objects ?  
    
   but which is not very clear by looking at the code. 
   a declarative DSL might help ?
   any way to generate code for the equals + hashCode contract ?
   can test (1) easily, not sure about others  
    
   and lint that no field can be missed ?
  
   also why choose 31 for hashCode ?
  
   ```java
    public int hashCode() {
       int result = name != null ? name.hashCode() : 0;
       result = 31 * result + age;
       result = 31 * result + (githubID != null ? githubID.hashCode() : 0);
       return result;
    }
   ```
  
5. was going to ask, is there a method to get the boolean value ?  
   but the question is non-sensensical  
   as only boolean can be a conditional  
   !!null or !!1 is not a boolean  
   ie. no autocast from a type to boolean  
   but if there a method to be overridden for converting to boolean ?  

6. compiler catches ArrayIndexOutOfBoundsException at compile-time
   but Intellij does not. why ?

   ```java
   Person[] persons = new Person[2];
   persons[2] = new Person()
   ```

7. why does switch not work with complex types ?
   when we can add a complex type to a hash and its hashCode and equals method is used
   why not use equals for switch ?
 
   ```java
   Person p1 = new Person("p1");
   Person p2 = new Person("p2");
  
   // does not work
   switch (p2) {
        case p1:
            System.out.println("switch to p1");
            break;
        case p2:
            System.out.println("switch to p1");
            break;
        default:
            System.out.println("nothing to switch");
   }  
  ```
  
8. Intellij inferred that a function is pure. how is that done ?
   it added an annotation named `@Contract(pure = true)` 
   is this part of any JSR ?
   what is the use of annotating that a function is pure ? any side-effects or only for documentation ?
   Intellij added a annotations jar for this
   are people using it in production ?
  
9. equals and hashCode is final in Enum
   so cannot be overridden
   why is that ?
   what other classes have equals and hashCode as final ?
   what method is used for matching switch ? equals ?
   can it be overridden ? 
   https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
   "A switch works with the byte, short, char, and int primitive data types.
   It also works with enumerated types (discussed in Enum Types), the String class,
   and a few special classes that wrap certain primitive types:
   Character, Byte, Short, and Integer (discussed in Numbers and Strings)." 
  
10. for an Enum what is the difference between Day.TUESDAY and TUESDAY ?
   Day.TUESDAY seems more like an instance and TUESDAY is special for switch statements ?
   and TUESDAY works as a switch case but Day.TUESDAY does not 
   why ?
  
  ```java
  public enum Day {
      SUNDAY,
      MONDAY,
      TUESDAY,
      WEDNESDAY,
      THURSDAY,
      FRIDAY,
      SATURDAY
  }
  ```
  
11. Integer is final and cannot define a sub-class of Integer
    are all types in core java final ?
    
12. does ruby have something similar to named loops and break ?

    ```java
    // can give labels to loops and break out of them specifically
    // normally break will break out of only the enclosing block ie. the next closing '}'
    int count = 0;
    OUTER_LOOP: while (count < 10) {
        switch (count) {
            case 5:
                System.out.println("midway");
                break;
            case 8:
                System.out.println("almost there");
                break OUTER_LOOP;
        }
    
        ++count;
    }
    System.out.println("count: " + count); // => 8
    ```
   
13. which collection to use when ?
    eg. ArrayList is resizeable, so always use it instead of an Array ?
    any desision tree or articles for which collection to use in which situation ?
    
    points to consider (i guess):
    1. thread safe
    2. size per item
    3. size of whole collection
    3. flexiblity
    
14. try splitting a project into 2 seperate repos/top-level projects
    eg. one project/repo for utilities
    and one for the actual app
    write gradle tasks for building utilities.jar and using it in the app
    will the dev cycle be ? 
    - change utilities code and build jar
    - refresh app project, so that updated utilities.jar is taken up
    - work on app
    or can intellij help in using the project as is and build the utilities.jar only for deployment ?
    will it be simpler if it is a single big project but with 2 namespaces - utilities and app
    
15. enums are final by default ?
    so cannot extend an enum ?
    
    ```java
    public enum Day {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
    
    // type error that cannot inherit from final Day 
    public enum StudidDay extends Day {
        ZORK_DAY,
        FOO_DAY
    }
    ```
    
16. testing libs with junit: 
    assertj, mockito,
    JUnitParams,
    junit-benchmarks, 
    wiremock, rest-assured
    jacoco
    does junit randomize tests with a new seed ?
    hamcrest vs assertj vs google truth ?
    can we customize the junit runner output ? make it more pretty ?
    try out TestNG as well
    
17. can Intellij tell if a gradle dependency is not being used ?
    is there a service to tell if gradle dependecies are out of date ?
    and/or have open security issues ?
    
18. general Q. while testing it is expected to have a failing and passing test  
    but is there any technique to enforce that ?  
    other than the moral character of the programmer :-) ?
    
19. opinion on Given, When and Then for testing ?  
    http://www.alexecollins.com/given-when-then-junit/  
    as an organization principle for tests ?  
    not using Gherkin, a non junit library or s special DSL  
    just simple blocks of code, commented with descriptive Given, When and Thens  
    
20. Intellij did not show warning for downcast which fails at runtime
 
    ```java
    public class Person {
        private String name;
        private int age; // defaults to 0 - if not initialized
        private Integer pinCode; // defaults to null - if not initialized
    
        public Person() {
        }
    
        public Person(String name) {
            this.name = name;
        }
    
        public Person(String name, int age, Integer pinCode) {
            this.name = name;
            this.age = age;
            this.pinCode = pinCode;
        }
     }
     
    public class Programmer extends Person {
        private Integer githubID;
     
        public Programmer(String name, Integer githubID) {
            super(name);
            this.githubID = githubID;
        }
     
        public Programmer(Person person) {
            super(person.getName());
        }
    }

     // downcast fails at runtime with ClassCastException. but Intellij did not show any warning
     // http://stackoverflow.com/questions/4862960/explicit-casting-from-super-class-to-subclass
     Programmer programmer2 = (Programmer) p1;
     System.out.println("person to programmer: " + programmer2);
    
     // works
     Programmer programmer3 = new Programmer(p1);
     System.out.println("explicit person to programmer: " + programmer3);
     ```

21. read interfaces vs abstract classes again.  
    https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
    
22. Intellij sucks with code navigation, when virtual method invocation is used with Polymorphism  
    
    ```java
    public class Person {
        private String name;
        private int age; // defaults to 0 - if not initialized
        private Integer pinCode; // defaults to null - if not initialized
        
        public Person() {
        }
        
        public Person(String name) {
            this.name = name;
        }
        
        public Person(String name, int age, Integer pinCode) {
            this.name = name;
            this.age = age;
            this.pinCode = pinCode;
        }
    }
         
    public class Programmer extends Person {
        private Integer githubID;
         
        public Programmer(String name, Integer githubID) {
            super(name);
            this.githubID = githubID;
        }
         
        public Programmer(Person person) {
            super(person.getName());
        }
    }
        
    // irritating that on navigating code, Intellij took me to Person.toString()
    // not Programmer.toString
    // even when Programmer.toString is called at runtime
    Person p4 = new Programmer("p4", 1);
    System.out.println("new person: " + p4.toString());

    ```
    
23. how to refer to methods while talking to people ?
    eg. in ruby we name a class method as . or ::
    ie. Person.config and # for instance methods
    eg. Person#age
    is more of a speaking and docs convention ?
    
    anything similar in Java ?
    
    ```java
    public class Programmer
            extends Person
            implements Hipster {
    
        public static Map<String, Object> getConfig() {
            Map<String, Object> config = new HashMap<String, Object>(3);
            config.put("address", "is not needed");
            config.put("knowledge of java", "is needed");
            return config;
        }
    
        public void requireJava() {
            Map<String, Object> config = Programmer.getConfig();
            config.get("knowledge of java");
        }
    }
    ```
    
    will both getConfig and requireJava be named as  
    Programmer.requireJava and Programmer.getConfig ?  
    
24. what is the use for the @Override annotation. documentation only ?
    Intellij can tell and navigate to the overridden method even 
    when @Override annotation is not there
    and it does not change the output of the program