# HUMANE Core HMN Model (hmn-core)

This project provides a Java implementation of the Core HMN Model developed in the 
HUMANE project by the University of Southampton IT Innovation Centre http://www.it-innovation.soton.ac.uk/.

The Core HMN Model was developed to support the modelling and simulation of
Human-Machine Networks. This model reflects key aspects of HMNs captured in the 
HUMANE typology to describe the actors, their interactions and structure of the network.

Further details about the HUMANE project, typology and simulation
modelling work can be found on: https://humane2020.eu.

# Copyright

The source code in this distribution is (c) Copyright University of Southampton 
IT Innovation Centre, 2017.

# Licences

The source code for hmn-core is provided under the LGPL v2.1; the licence 
agreement for this can be found in the LICENSE file and folder named 'licences'.

A complete list of licences for this software and associated third party
software can be found in the IPR.md file.

# Software Dependencies

The following 3rd party software is required:

* Java 1.8
* Maven 3.x

## Setting up Java and Maven

Please refer to the respective software provider's instructions:

* Java JDK: http://www.oracle.com/technetwork/java/javase/downloads/index.html
* Maven: http://maven.apache.org/download.cgi

# Building the hmn-core software

This software requires maven 3.x to build, which you can do with the follow command:

```
  mvn install
```

To generate JavaDoc, the package profile must be used when compiling the code:

```
  mvn install -P package
```

The JavaDoc will be created in ./target/javadoc

