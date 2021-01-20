# JaCoCo Listeners

## Build

```
mvn clean install
```

## Measurement

### Configure the POM of the program under test

```
</dependencies>
	...
	<dependency>
		<groupId>hu.szte.sed</groupId>
		<artifactId>jacoco-listeners</artifactId>
		<version>0.0.1</version>
		<scope>test</scope>
	</dependency>
	...
</dependencies>
```

```
<build>
	...
	<plugins>
		...
		<plugin>
			<artifactId>maven-surefire-plugin</artifactId>
			<version>2.22.2</version>
			...
			<configuration>
				...
				<properties>
					<listener>hu.szte.sed.JUnitListener</listener>
					...
				</properties>
				...
			</configuration>
			...
		</plugin>
		
		<plugin>
			<groupId>org.jacoco</groupId>
			<artifactId>jacoco-maven-plugin</artifactId>
			<version>0.8.6</version>
		</plugin>
		...
	</plugins>
	...
</build>
```

### Run the tests

```
mvn clean jacoco:prepare-agent test jacoco:report -Dmaven.test.failure.ignore=true
```
