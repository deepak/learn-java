### Questions

- why does int default to 0 and Integer (boxed) default to null ?

- @NotNull annotation  
  can use javax @NotNull annotation with spring, or guice also i think. 
  but which one to use ?
  http://stackoverflow.com/questions/4963300/which-notnull-java-annotation-should-i-use
  https://jcp.org/en/jsr/detail?id=305
  
- is there a good java REPL ?
  can always put a debugger in Intellj and evaluate any code!
  how does Intellij do that ? any product it uses like
  http://www.crashub.org
  http://www.beanshell.org/intro.html
  https://code.google.com/p/cliche/
  
  JEP 222: jshell: The Java Shell (Read-Eval-Print Loop)
  http://openjdk.java.net/jeps/222
  
- Intellij has a wizard for generating equals and hashCode
  
  - accept subclasses
  - use getters
  - fields to include in equals
  - fields to include in hashCode
  - select not-null fields so that null check can be skipped
  
  any way to declaratively encode these decisions, rather than generating code ?
  mabe a DSL
  
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
  


  