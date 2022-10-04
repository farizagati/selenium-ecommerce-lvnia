# Selenium Ecommerce
Created by <a href="https://bit.ly/inFarizAgati">M Fariz Agati</a><br>
Stack details:
- Selenium Java v4.5.0
- Cucumber Framework

## Scenario that being used
Scenario: I want to search a specific product and perform smoke testing functionality on cart and courier options<br>
    Given Open website "https://www.elevenia.co.id"
    <br>And Located on elevenia website
    <br>Then I search for product terlaris in "Komputer" keyword
    <br>Then I add "3" items to my shopping cart
    <br>Then I go to cart section
    <br>Then I modify the courier option
    <br>Then I cancel to modify the courier option
    <br>Then I cancel the product on my shopping cart

## How to run the automation test
Make sure you already installed (and configured):<br>
1. Java (min. version 11), including setting up JAVA_HOME ,etc<br>
2. IDE (either Eclipse, or IntelijIDEA, but I personally using IntelijIDEA for scripting this code)<br>

All you need to do is just clone this repository.<br>
You can use your terminal / git cmd with command:<br>

`git clone https://github.com/farizagati/selenium-ecommerce-lvnia.git`

After that, try to run the file "testng.xml" that located on the parent folder.<br/>
If you have any questions, you can reach to me via: agatifariz@gmail.com
