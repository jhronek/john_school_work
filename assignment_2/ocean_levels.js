/*
	John Hronek
	COP2801
	Assignment 2: ocean_levels.js

	Program:
	Assuming the ocean's level is currently rising at about 1.6 millimeters per year,
	write a program called ocean_levels.js, that displays the number of millimeters, 
	that the ocean will have risen each year for the next 25 years. 

	Input:
	risePerYear = 1.6 mm / year GIVEN

	Process:
	loop to 25 years and add 1.6mm each time

	Output:
	total mm ocean rise over 25 years

*/

function risingOcean(a) {
	var risePerYear = 1.6;
	var totalRisen = 0;
	for (var i = 0; i < a; i++) {
		totalRisen += risePerYear;
	}
	return totalRisen;
}

console.log("After 25 years the ocean will have risen approximately" + risingOcean(25).toFixed(3) + "mm.");