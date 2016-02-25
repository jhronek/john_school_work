/*
  John Hronek
  COP2801
  Assignment 1

  A customer in a store is purchasing five items. Write a
  program called total_purchase.js that creates five items
  with literal numeric values. The prices of the items should
  be as follows:
    item 1: $9.99
    item 2: $5.99
    item 3: $.99
    item 4: $59.50
    item 5: $.25

  It then calculates and displays the subtotal of the sale,
  the amount of sales tax, and the total. Assume the sales
  tax is 7 percent. Display the answer to two decimal
  places. 25 pts

  Input:
	item 1: $9.99	GIVEN
	item 2: $5.99	GIVEN
	item 3: $.99	GIVEN
	item 4: $59.50	GIVEN
	item 5: $.25	GIVEN
	sales tax: 7%	GIVEN
	
  Process:
	subtotal = item1 + item2 + item3 + item4 + item5
	total = subtotal + (subtotal * sales tax)
  Output:
	subtotal
	sales tax
	total
*/

var item1 = 9.99;
var item2 = 5.99;
var item3 = 0.99;
var item4 = 59.50;
var item5 = 0.25;
var salesTax = 0.07;
var subtotal = 0;
var total = 0;

subtotal = item1 + item2 + item3 + item4 + item5;

total = subtotal + (subtotal * salesTax);

console.log("Your items cost this much: ");
console.log(item1.toFixed(2));
console.log(item2.toFixed(2));
console.log(item3.toFixed(2));
console.log(item4.toFixed(2));
console.log(item5.toFixed(2));
console.log("Your subtotal = $" + subtotal.toFixed(2));
console.log("Sales tax = " + (salesTax * 100).toFixed(0) + "%");
console.log("Your total with sales tax = $" + total.toFixed(2));
