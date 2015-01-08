# spring-boot-classpath-sample
Help from http://stackoverflow.com/questions/27825904/no-qualifying-bean-of-type-org-springframework-jdbc-core-jdbctemplate-with-sprin

Launch :
```
mvn package
cp src/test/resources/batch-configuration.properties target
cd target
java -Dloader.path=.,lib -jar batch-1.0-SNAPSHOT.jar
```