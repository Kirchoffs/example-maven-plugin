## Example Maven Plugin

### Test the plugin
```
>> mvn clean install
>> mvn org.syh.plugin:example-maven-plugin:version
>> mvn org.syh.plugin:example-maven-plugin:version -Dgit.command="git rev-parse HEAD"
```

### Test the plugin from another Maven project
```
>> mvn package -f plugin-usage-example/pom.xml
```