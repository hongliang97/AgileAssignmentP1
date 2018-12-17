/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function checkFlowerLimit(){

if(document.getElementById('s1').checked){
    var max1 = 1;
}else if(document.getElementById('s2').checked){
    var max1 = 2;
}else if(document.getElementById('s3').checked){
    var max1 = 3;
}else{
    var max1 = 0;
}

return max1;
}

function checkAccessoryLimit(){

if(document.getElementById('s1').checked){
    var max1 = 1;
}else if(document.getElementById('s2').checked){
    var max1 = 1;
}else if(document.getElementById('s3').checked){
    var max1 = 2;
}else{
    var max1 = 0;
}
return max1;
}

function Count() {
var max = checkFlowerLimit() + 1;
var realmax = max - 1;

var NewCount = 0;

if (document.flowers.f1.checked)
{NewCount = NewCount + 1}

if (document.flowers.f2.checked)
{NewCount = NewCount + 1}

if (document.flowers.f3.checked)
{NewCount = NewCount + 1}

if (document.flowers.f4.checked)
{NewCount = NewCount + 1}

if (document.flowers.f5.checked)
{NewCount = NewCount + 1}

if (document.flowers.f6.checked)
{NewCount = NewCount + 1}

if (document.flowers.f7.checked)
{NewCount = NewCount + 1}

if (document.flowers.f8.checked)
{NewCount = NewCount + 1}

if (document.flowers.f9.checked)
{NewCount = NewCount + 1}

if (document.flowers.f10.checked)
{NewCount = NewCount + 1}

if (document.flowers.f11.checked)
{NewCount = NewCount + 1}

if (document.flowers.f12.checked)
{NewCount = NewCount + 1}

if (document.flowers.f13.checked)
{NewCount = NewCount + 1}

if (document.flowers.f14.checked)
{NewCount = NewCount + 1}

if (document.flowers.f15.checked)
{NewCount = NewCount + 1}


if (NewCount == max)
{
alert('You are only able to choose ' + realmax + ' types of flowers')
document.flowers; return false;
}
} 

function Count11() {
var max = checkFlowerLimit() + 1;
var realmax = max - 1;

var NewCount = 0;

if (document.flowerssss.fff1.checked)
{NewCount = NewCount + 1}

if (document.flowerssss.ff2.checked)
{NewCount = NewCount + 1}

if (document.flowerssss.fff3.checked)
{NewCount = NewCount + 1}

if (document.flowerssss.fff4.checked)
{NewCount = NewCount + 1}

if (document.flowerssss.fff5.checked)
{NewCount = NewCount + 1}

if (document.flowerssss.fff6.checked)
{NewCount = NewCount + 1}

if (document.flowerssss.fff7.checked)
{NewCount = NewCount + 1}

if (document.flowerssss.fff8.checked)
{NewCount = NewCount + 1}


if (NewCount == max)
{
alert('You are only able to choose ' + realmax + ' types of flowers')
document.flowerssss; 
return false;
}
} 



function Count1() {
var max = checkAccessoryLimit() + 1;
var realmax = max - 1;

var NewCount = 0;

if (document.accessories.a1.checked)
{NewCount = NewCount + 1}

if (document.accessories.a2.checked)
{NewCount = NewCount + 1}

if (document.accessories.a3.checked)
{NewCount = NewCount + 1}

if (document.accessories.a4.checked)
{NewCount = NewCount + 1}

if (document.accessories.a5.checked)
{NewCount = NewCount + 1}

if (document.accessories.a6.checked)
{NewCount = NewCount + 1}

if (document.accessories.a7.checked)
{NewCount = NewCount + 1}

if (document.accessories.a8.checked)
{NewCount = NewCount + 1}

if (document.accessories.a9.checked)
{NewCount = NewCount + 1}

if (document.accessories.a10.checked)
{NewCount = NewCount + 1}

if (document.accessories.a11.checked)
{NewCount = NewCount + 1}

if (document.accessories.a12.checked)
{NewCount = NewCount + 1}

if (document.accessories.a13.checked)
{NewCount = NewCount + 1}

if (document.accessories.a14.checked)
{NewCount = NewCount + 1}

if (document.accessories.a15.checked)
{NewCount = NewCount + 1}


if (NewCount == max)
{
alert('You are only able to choose ' + realmax + ' types of accesories')
document.flowers; return false;
}
} 