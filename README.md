# Mutation testing using Pitest[http://pitest.org/]

**Coverage != Quality**

##About Project
This is a maven sample project to try mutation testing. The repo contains the following files
1. FundService.java - Before mutation testing
2. FundServiceMutationCovered - After refactoring the code based on insights from the report generated.

##Overview of Mutators. Read more at the link below
Mutation Operators [http://pitest.org/quickstart/mutators/]


##Maven plugins and dependencies
The maven file has the following plugins and dependencies.

- Include pitest version.
```
<properties>
        <!-- https://maven.apache.org/general.html#encoding-warning -->
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <junit.version>5.3.1</junit.version>
        <pitest.version>1.4.3</pitest.version>
 </properties>
      
```

- Include plugin and goal
```
....
<plugin>
         <groupId>org.pitest</groupId>
         <artifactId>pitest-maven</artifactId>
         <version>${pitest.version}</version>

          <executions>
              <execution>
                  <id>pit-report</id>
                  <phase>test</phase>
                   <goals>
                       <goal>mutationCoverage</goal>
                   </goals>
              </execution>
          </executions>
                ....
                ....
 </plugins>

```

- Include pitest dependencies
```

....
<dependencies>
     <dependency>
         <groupId>org.pitest</groupId>
         <artifactId>pitest-junit5-plugin</artifactId>
         <version>0.8</version>
     </dependency>
</dependencies>
....

```

- Target Classes Configuration:Mutation testing consumes a lot of resources and is slow. This section helps to selectively run pitest.
```
<configuration>
      <targetClasses>
        <param>com.awmalts.mutationsample.FundService</param>
      </targetClasses>
      <targetTests>
        <param>com.awmalts.mutationsample.FundServiceTest</param>
      </targetTests>
</configuration>
....

```

- Mutators Configuration - 
```
....

<configuration>
    <mutators>
        <mutator>CONSTRUCTOR_CALLS</mutator>
        <mutator>NON_VOID_METHOD_CALLS</mutator>
        ....
    </mutators>
</configuration>
....

```

##Default Mutators Activated
- Conditionals Boundary Mutator
- Increments Mutator
- Invert Negatives Mutator
- Math Mutator
- Negate Conditionals Mutator
- Return Values Mutator
- Void Method Calls Mutator


##Running pitest
```
mvn org.pitest:pitest-maven:mutationCoverage
```
- Make sure mvn is in the path and run the above from the terminal prompt. 
- On BUILD SUCCESS - the pitest reports can be found in the project ```target\pit-reports\``` folder

NOTE: Build Fails when
- there are no tests
- when tests fail

### That's it. Give it a go...!!
- Open the Pit Test Coverage Report from the folder to view.

### Want to see what the refactored coverage report looks like?? 
- Copy the following into the POM configuration section
```
<targetClasses>
   <param>com.awmalts.mutationsample.FundService</param>
   <param>com.awmalts.mutationsample.FundServiceMutationCovered</param>
</targetClasses>
<targetTests>
   <param>com.awmalts.mutationsample.FundServiceTest</param>
   <param>com.awmalts.mutationsample.FundServiceMutationCoveredTest</param>
</targetTests>
```
 - Run the mvn command as before from the terminal.
 - Open the Pit Test Coverage Report from the folder to view both the classes included in the report.
 
 
 **## END ##**
 
