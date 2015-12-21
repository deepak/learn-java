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
  


  