/*
  John Hronek
  COP2801
  Assignment 1

  One acre of land is equivalent to 43,560 square feet. Write
  a program called land_calculation.js that calculates the
  number of acres in the tract of land based on the total
  square feet in a tract of land. Use a literal value of
  348,480 for the total square feet. 25 pts

  Input:
    one acre = 43,560 square feet
    total square feet = 348,480

  Process:
    number of acres = total square feet / 43,560 (1 acre)

  Output:
    number of acres in the tract of land


*/

var oneAcre = 43560;
var totalSquareFeet = 348480;

var numberOfAcres = totalSquareFeet / oneAcre;

console.log("The total number of acres is: " + numberOfAcres);