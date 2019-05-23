#!/bin/bash

# Run from parent folder to create folder javaSeWeldDemo with initial application

mvn archetype:generate \
	-DgroupId=com.github.oliverpavey \
	-DartifactId=javaSeWeldDemo \
	-DinteractiveMode=false
