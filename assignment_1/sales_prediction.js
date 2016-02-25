/*
  John Hronek
  COP2801
  Assignment 1

  A company has determined that its annual profit is
  typically 23 percent of total sales. Write a program
  called sales_prediction.js, that displays the profit based
  on the project amount of total sales for the year. Use a
  literal value of $2,500,000 for the projected total sales
  amount. Display the profit amount formatted to two decimal
  places. 25 pts

  Input:
    projected sales = 2,500,000
    annual profit percentage = 23%

  Process:
    projected profit = projected sales * annual profit

  Output:
    projected profit formatted to 2 decimal places

*/

var projectedSales = 2500000;
var annualProfit = .23;

var projectedProfit = projectedSales * annualProfit;

console.log("The profit based on the projected total sales is: " + projectedProfit.toFixed(2));