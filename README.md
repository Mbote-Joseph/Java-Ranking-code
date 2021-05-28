# Java-Ranking-code

Problem 3:

A professor has posted a list of student numbers and marks. Write a program to read the marks and compute the rank of a student in class. The rank is computed using the usual manner as follows: if the student has the top mark (or is tied for the top mark) his rank is 1; if he has the second best mark (or is tied) his rank is 2, and so on.

Input (from a file called rank.in)

The input consists of several test cases. Each case begins with Ahmed's student number, an integer between 1000000 and 9999999. Following the student number are a number of lines, each containing a student number between 1000000 and 9999999 and a mark between 0 and 100. A line with a student number and mark of 0 terminates each test case. There are no more than 1000 students in the class, and each has a unique student number.

Output (to a file called rank.out)

For each test case, output a line giving Ahmed's rank in the class.

Sample Input 1
1234567
1212121 100
1234567 33
2222222 22
9898765 33

Output for Sample Input 1
2

Sample Input 2
1234567
1212121 100
1234567 22
2222222 33
9898765 33

Output for Sample Input 2
4
