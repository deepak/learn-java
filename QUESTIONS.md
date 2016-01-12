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
    
25. for inheritance any way of inheriting tests as well with junit, other than copy-and-paste ?
    eg. we have an Person class and a Programmer class which inherits from Person
    Person has 4 tests (including one for forString and constructor)
    so Programmer has 2 common test (maybe)
    seems like a stupid Q. would create a custom matcher in rspec (ruby)
    any other options ?
    try out abstract junit test class
    
26. why is the constructor in a abstract class special ?
    no need to override the getter and setter in a abstract class
    but need to do for the constructor ?
    
    ```java    
    public abstract class ChecklistItem {
    
        public String name;
    
        public ChecklistItem(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public abstract String getFormalName();
    }
    
    public class TodoItem extends ChecklistItem {
        public TodoItem(String name) {
            super(name);
        }
    
        @Override
        public String getFormalName() {
            return "[TODO] " + name;
        }
    }
    ```
    
27. can we add an abstract constructor ?

    ```java
    public abstract class ChecklistItem {
    
        public String name;
    
        public ChecklistItem(String name) {
            this.name = name;
        }
        
        // not allowed
        //public abstract ChecklistItem(int one, int two);
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public abstract String getFormalName();
    }
    ```
    
28. ruby question
    calling a different super-class method in the base-class 
    https://gist.github.com/deepak/5fe96a9a70d2693b8df3
    
29. what is the convention for writing the method signature ?
    eg. both `public abstract String getFormalName();` and `abstract public String getFormalName();` 
    works in an abstract class
    
30. why are the suggested type parameter names, one char long ?

    https://docs.oracle.com/javase/tutorial/java/generics/types.html
    The most commonly used type parameter names are:
    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types
    
    Although other names also work eg. Type in-place of T
    
31. type parameter does not have super class etc ?
    what is the type heirarchy
    
    ```java
    public class Box<Type> {
        private Type t; // not the same as the main.Type class
        private AnotherType t2;
        private main.Type mainType;
    
        public Box() {
            this.t2 = new AnotherType();
            this.mainType = new main.Type();
        }
    
        public void set(Type t) {
            this.t = t;
        }
    
        public Type get() {
            return t;
        }
    
        @Override
        public String toString() {
            // cannot get Type.getClass()
            return "Box{" +
                    "mainType=" + mainType +
                    ", t=" + t +
                    ", t2=" + t2 +
                    '}';
        }
    }
    ```
    
32. why do generics not work with primitive types ?

33. Intellij does not suggest to use Integer, for an int (primitive) array

    ```java
     int[] arr3 = new int[] { 1, 2, 3, 4};
    
    swapItems(1, 3, arr3);
    
    public static <T> void swapItems(int i, int j, T[] arr) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    ```
    
    suggests changing the method signature to `public static <T> void swapItems(int i, int j, int[] arr)`
    which leaves a compile error
    
    two other suggestions are to change & migrate array type to Object[]
    array becomes, `Object[] arr3 = new int[] { 1, 2, 3, 4};` is the first one
    and `Object[] arr3 = new Object[] { 1, 2, 3, 4};` for the second
    
    the most obvious refactoring would have been to migrate to Integer
    which is not suggested
    
34. what is the difference between, 
    the generic and the polymorphic version ?

    ```java
     public static <T> void swapItems(int i, int j, T[] arr) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
     }
    
     public static void swapObjects(int i, int j, Object[] arr) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
     }
    ```
    
    how is the generic version useful, not as if i can say something like
    only swap Strings and Persons ?
    
35. how to make sure a generic class always has an instance of a parameterized type
    Box (below) always has an instance of Type
    can create a constructor. how to DI with Spring ?
    

    ```java
    public class Box<T> {
        private T t1;
        private AnotherType t2;
    
        public Box(T t1) {
            // no way for us to do, `new T()`
            this(t1, new AnotherType());
        }
    
        public Box(T t1, AnotherType t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
    
        public void set(Type t) {
            this.t = t;
        }
    
        public Type get() {
            return t;
        }
    
        @Override
        public String toString() {
            return "Box{" +
                    "mainType=" + mainType +
                    ", t=" + t +
                    ", t2=" + t2 +
                    '}';
        }
    }
    ```
    
36. code golf. how to check if method is overridden for class ?
    https://gist.github.com/deepak/eb8738218f422829496a
    
37. how to see inferred type ?
    other than intellij gui

    ```java
       public class RandomList<E> extends AbstractList<E>
               implements List<E>, RandomAccess, Cloneable, java.io.Serializable, Comparable<E>, CharSequence {
           @Override
           public E get(int index) {
               return null;
           }
       
           @Override
           public int size() {
               return 0;
           }
       
           @Override
           public int compareTo(E o) {
               return 0;
           }
       
           @Override
           public char charAt(int index) {
               return 0;
           }
       
           @Override
           public int length() {
               return 0;
           }
       
           @Override
           public CharSequence subSequence(int start, int end) {
               return null;
           }
       }
    
       Serializable pick1 = pick("d", new ArrayList<String>());
       String pick2 = pick("a", new String());
       // intellij is still showing the type parameter as Serializable
       CharSequence pick3 = pick("a", new RandomList<Integer>());
    ```
    
38. generic constructors ?
    also type inference left me confused.   
    what algo. does java use for type inference ?  
    is scala magic preferable or is there a better explanation  
    maybe read it again  

    https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html
    
    how to use ?
    
    ```java
    class MyClass<X> {
      <T> MyClass(T t) {
        // ...
      }
    }
    ```
    
    and what would be an actual example ?
    
39. what is the difference btw
    regular bounded type and wildcard bounded type
    `<T extends Animal>` and `<? extends Animal>`
    
40. is there a list of all the possible generic invocations
    or something like `http://cdecl.org in c++`
    not sure how complex the java ones can become though
    
41. why does Java have the rule about one public class per file  ? class-loading ?
    there can be a different non-public class inside the same file though 
    
    ```java
    # foo.java file
    
    public class Foo {
    }
    
    class FooHelper {
    }
    ```
    
42. how to auto-complete gradle tasks and options in `build.gradle`

43. how to see warning for unchecked generics in gradle

    ```java
      public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("hop");
        System.out.println("stringBox: " + stringBox);
        // stringBox.set(10); // is a type-error
    
        Box rawBox = new Box<String>();
        rawBox.set("rat");
        System.out.println("rawBox: " + rawBox);
    
        // not a type-error even though variable is initialized as `Box<String>()`
        // this is because we are using a raw type
        rawBox.set(10);
        System.out.println("rawBox: " + rawBox);
      }
    ```
    
44. Intellij add comments (glypy ? ie. //) to the extreme left
    want it nearer to the line
    
    rather than:
    ```java
//        Box<String> box1 = new Box<>();
//        box1.set("foo");
//        Box<String> box2 = new Box<>();
//        box2.set("bar");
//        System.out.println("boxes the same: " + Util.compare(box1, box2));
    ```
    
    more like:
    
    ```java
    // Box<String> box1 = new Box<>();
    // box1.set("foo");
    // Box<String> box2 = new Box<>();
    // box2.set("bar");
    // System.out.println("boxes the same: " + Util.compare(box1, box2));
    ```
    
45. what is the big deal with raw types ? and how to make it crash

    ```java
    public class Main {
    
        public static void main(String[] args) {
            Box<String> stringBox = new Box<>();
            stringBox.set("hop");
            System.out.println("stringBox: " + stringBox);
            // stringBox.set(10); // is a type-error
    
            Box rawBox = new Box<String>();
            rawBox.set("rat");
            System.out.println("rawBox: " + rawBox);
    
            // not a type-error even though variable is initialized as `Box<String>()`
            // this is because we are using a raw type
            rawBox.set(10);
            System.out.println("rawBox: " + rawBox);
    
            Pair<Integer, String> p1 = new Pair<>(1, "apple");
            Pair<Integer, String> p2 = new Pair<>(2, "pear");
            // boolean same = Util.<Integer, String>compare(p1, p2);
            boolean same = Util.compare(p1, p2);
            System.out.println("pairs are the same" + same);
    
            Person person1 = new Person("foo");
            Person person2 = new Person("bar");
            System.out.println("person same: " + Util.compare(person1, person2));
    
            Box<String> box1 = new Box<>();
            box1.set("foo");
            Box<String> box2 = new Box<>();
            box2.set("bar");
            System.out.println("boxes the same: " + Util.compare(box1, box2));
    
            Box<Integer> box3 = new Box<>();
            box3.set(1);
            Box<Integer> box4 = new Box<>();
            box4.set(10);
            System.out.println("boxes the same: " + Util.compare(box3, box4));
            // System.out.println("boxes the same: " + Util.compare(box1, box4)); // type-error
    
            // is the magic of raw types ? no type error
            // TODO: is which case is this a bad idea ? make it crash
            Box rawBox1 = new Box<>();
            rawBox1.set(1);
            Box rawBox2 = new Box<>();
            rawBox2.set("10");
            System.out.println("raw boxes the same: " + Util.compare(rawBox1, rawBox2));
    
            PersonBox rawPersonBox = new PersonBox();
            rawPersonBox.set(person1);
            System.out.println("rawPersonBox: " + rawPersonBox);
    
            // rawPersonBox.set("foo"); // is a type-error. why now ?
        }
    }
    
    public class Box<T> {
        private T t;
    
        public Box() {
            // noop
        }
    
        public void set(T t) {
            this.t = t;
        }
    
        public T get() {
            return t;
        }
    
        @Override
        public String toString() {
            return "Box{" +
                    "t=" + get() +
                    '}';
        }
    }
    
    class PersonBox<T extends Person> {
        private T t;
    
        public PersonBox() {
            // noop
        }
    
        public void set(T t) {
            this.t = t;
        }
    
        public T get() {
            return t;
        }
    
        @Override
        public String toString() {
            return "PersonBox{" +
                    "name=" + get().getName() +
                    '}';
        }
    }
    
    public class Pair<K, V> {
    
        private K key;
        private V value;
    
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    
        public void setKey(K key) { this.key = key; }
        public void setValue(V value) { this.value = value; }
        public K getKey()   { return key; }
        public V getValue() { return value; }
    }
    
    class Person {
        private String name;
    
        public Person(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    }
    
    class Util {
        public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
            return p1.getKey().equals(p2.getKey()) &&
                    p1.getValue().equals(p2.getValue());
        }
    
        public static <T> boolean compare(Box<T> b1, Box<T> b2) {
            // will not allow me to call person specific code
            // or even call instanceof
    
            // type-error: cannot cast
            // if (b1 instanceof Person) {
            //     // type-error: cannot resolve getName
            //     return b1.get().getName().equals(b2.get().getName());
            // }
            return b1.get().equals(b2.get());
        }
    
        // clashes with `public static <T> boolean compare(Box<T> b1, Box<T> b2)` above
        // due to type erasure
        // public static <T extends Person> boolean compare(Box<T> b1, Box<T> b2) {
        //    return b1.get().getName().equals(b2.get().getName());
        // }
    
        public static boolean compare(Person p1, Person p2) {
            return p1.getName().equals(p2.getName());
        }
    }
    ```
    
46. how to easily implement `toString` for class extending ArrayList ?
    can copy-paste from AbstractCollection but 
    Intellij does not generate it ? 

    ```java
    public class NumberList<E extends Number> extends ArrayList<E> {
        @Override
        public Stream<E> parallelStream() {
            return null;
        }
    
        @Override
        public Stream<E> stream() {
            return null;
        }
    }
    ```
    
47. how to write ?

    ```java
    // works
    public class NumberList<E extends Number> extends ArrayList<E>
    
    // does not work. how to write this
    class UntilNumberList<? extends Number> extends ArrayList<?>
    ```

