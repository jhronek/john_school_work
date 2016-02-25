/*
	John Hronek
	COP 2801
	Assignment 2: population.js

	Write a program called population.js, that predicts the approximate size of a
	population of organisms. The program should use the following data:

	Starting number of organisms: 2

	Average daily increase: 30%

	Number of days to multiply: 10

	The program should display the following table of data:

	Day Approiximate     Population
	1                        2

	2                        2.6

	3                        3.38

	4                        4.394

	5                        5.7122

	6                        7.42586

	7                        9.653619

	8                        12.5497

	9                        16.31462

	10                       21.209

	Input:
	
	starting organisms = 2
	average daily increase = 30%
	number of days to multiply = 10

	Process:
	
	create method popIncrease(starting organisms, avg daily increase, days to multiply)

	Output:
	
	headers for : Day and Approiximate Population
	calculated data for the Day and the approximate population on that day
*/

var startOrganisms = 2;
var avgDailyIncrease = .30;
var daysToMultiply = 10;

function popIncrease(start, increase, days) {
	var newPop = start;
	var day = 1;
	console.log("Day\t\tApproximate Population");
	for (day; day < days + 1; day++) {
		console.log(day + "\t\t" + newPop.toFixed(4) + "\n");
		newPop += (newPop * increase);
	}
}

popIncrease(startOrganisms, avgDailyIncrease, daysToMultiply);