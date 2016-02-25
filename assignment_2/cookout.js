/*
	John Hronek
	COP2801
	Assignment 2: cookout.js

	Problem:
	Assume that hot dogs come in packages of 10, and hot dog buns come in
	packages of 8. Write a program called cookout.js, that calculates the
	number of packages of hot dogs and the number of packages of hot dog
	buns needed for a cookout, with the minimum amount of leftovers.
	The program should assume there will be 525 people attending the
	cookout and each person will eat 3 hot dogs.  The program should
	display the following details.

	The minimum number of packages of hot dogs required.

	The minimum number of packages of hot dog buns required.

	The number of hot dogs that will be left over.

	The number of hot dog buns that will be left over.

	Input:
	525 people
	10 hot dogs per package
	8 hot dog buns per package
	people will eat 3 hot dogs each

	Process:
	totalEaten = 525 people * 3 each
	minDogs = Math.floor(totalEaten / hotDogPackage)
	minBuns = Math.floor(totalEaten / bunsPackage)
	leftoverDogs = totalEaten % hotDogPackage
	leftoverBuns = totalEaten % bunsPackage

	Output:
	min. number of packages of hot dogs
	min. number of packages of hot dog buns
	number of hot dogs that will be left over
	number of hot dog buns that will be left over

	*/

var people = 525;
var hotDogPackage = 10;
var bunsPackage = 8;
var totalEaten = people * 3;
var leftoverDogs = 0;
var leftoverBuns = 0;

minDogs = Math.floor(Math.round(totalEaten / hotDogPackage));
minBuns = Math.floor(Math.round(totalEaten / bunsPackage));
leftoverDogs = ((minDogs*hotDogPackage) - totalEaten);
leftoverBuns = ((minBuns*bunsPackage) - totalEaten);
console.log("For a party of 525 people that each eat 3 hot dogs you will need:");
console.log("The minimum number of packages of hot dogs is: " + minDogs);
console.log("The minimum number of packages of hot dog buns is: " + minBuns);
console.log("The number of hot dogs that will be left over is: " + leftoverDogs);
console.log("The number of hot dog buns that will be left over is: " + leftoverBuns);