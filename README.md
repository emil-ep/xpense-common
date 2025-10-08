# **Xpense-Common**

This repository contains all the common models and functions that are distributed between all the repositories of 
org.xperia

This repository also hosts artifactory of github. So in order to read and write from this package, you need to follow 
below steps

## Configuring github package

1. Edit your settings.xml
2. Update your < profiles > section with the below details
```
   <profile>
        <id>github</id>
        <repositories>
            <repository>
                <id>central</id>
                <url>https://repo.maven.apache.org/maven2</url>
            </repository>
            <repository>
                <id>github</id>
                <url>https://maven.pkg.github.com/emil-ep/xpense-common</url>
                <snapshots>
                    <enabled>true</enabled>
                </snapshots>
            </repository>
        </repositories>
   </profile>
```
3. Take a build using `mvn clean install`
4. Push it to the artifactory using `mvn deploy`

### Make sure you update changelog.md before your publish a new package