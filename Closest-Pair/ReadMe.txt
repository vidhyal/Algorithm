This program implements the closest-pair algorithm where the measuring distance used is Manhattan distance as opposed to the usual Euclidean distance . The difference is denoted by the method dist() that takes in two 2D integral points and returns an integer (the Manhattan distance between the points). Since Euclidean distance could be a floating point value but Manhattan distance is always integral for integral start and end points, all metrics used by the program are integral.  

It takes an input file in the format:
. First line contains a number C>= 0 of test cases n the file.
. Then comes C test cases, each of the following form:
	- Line containing the number n>=2 of points in the test.
	- Line containing the 2n coordinates of the n points in order x1 y1 x2 y2 ... xn yn,  with exactly one space separation between each number.