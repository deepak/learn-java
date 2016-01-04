## Lints

1. all Overridden methods must have an `@Override` annotation
   kind of useless though. good for only documentation
   Intellij can tell and navigate to the overridden method even 
   when @Override annotation is not there
   and it does not change the output of the program
2. using a c style for loop for a collection.
   eg. use `for (Foo a : arr)` rather than `for (int i = 0; i < arr.length(); i++)`


## Style Guide

1. a good java style guide ? 
   - https://github.com/google/styleguide/
     https://google.github.io/styleguide/javaguide.html
   - http://www.javaranch.com/style.jsp
   and how to enforce it ?  
   
2. like "go format", format java code  

## Tools

- https://github.com/mcandre/linters#java

  [javac](http://www.oracle.com/technetwork/java/javase/downloads/index.html) offers a `-Xlint` option to print additional warnings. The [maven-compiler-plugin](https://maven.apache.org/plugins/maven-compiler-plugin/compile-mojo.html) can be configured to automatically pass `-Xlint` to the underlying Java compiler every time a project is built.
  
  In Java 8, javac will feature an `-Xdoclint` option to identify undocumented code.
  
  [CheckStyle](http://checkstyle.sourceforge.net/), with decent CLI support, as well as decent Maven support, through [maven-checkstyle-plugin](http://maven.apache.org/plugins/maven-checkstyle-plugin/). Checkstyle also supports identifying undocumented code, through its [JavaDoc](http://checkstyle.sourceforge.net/config_javadoc.html) settings.
  
  [FindBugs](http://findbugs.sourceforge.net/) is an old Java linter, but has kept up with Java advances (for example, by offering a standard Gradle plugin).
  
  [PMD](http://pmd.sourceforge.net/) detects flaws and duplicated code.
  
  [Error-prone](https://github.com/google/error-prone) catches common Java mistakes as compile-time errors.
  
  [Android lint](http://tools.android.com/tips/lint) checks Android source files for potential bugs and optimization improvements for correctness, security, performance, usability, accessibility, and internationalization.
  
  [Infer](http://fbinfer.com/) is a static program analyzer for Java, C, and Objective-C, written in OCaml.
  
- jlint
  http://artho.com/jlint/
- https://atom.io/packages/linter-javac