## About

This is an exercise project i made to learn some of the new features introduced between JKD8 -> JDK11

I wanted to have a feel of things like:
* module
* var keyword
* jlink

The app is a simple Swing application that sorts an array of configurable sizes using multiple algorithms

Each algorithm is implemented as a module. The gui module is unaware of exactly how many algorithms are there. At runtime it asks the module system to give it all available algorithm implementation before using them to sort the input in parallel.

## Pre-requisites
* An Open JDK11 distribution. I use Zulu, by Azul.
* Maven 3.6
* **Note**: I only tested this on my windows pc. No clue if the app will work on any other OS

## How to build and run
* Type mvn clean (package|install)
* cd into mod-jlink folder
* Type mvn exec:exec
* cd into target/jlinked/bin folder
* Type launch

