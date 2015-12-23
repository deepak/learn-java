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