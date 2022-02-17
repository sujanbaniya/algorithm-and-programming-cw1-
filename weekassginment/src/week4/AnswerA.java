package week4;


public class AnswerA {
 public static void main(String[] args) {
double[][] points = {{4, 4}, {2, 3}, {5, 8}, {3, 4}, {5, 7}};
double[] cordinate = {3, 4};
double[] result = nearestPoint(cordinate, points);
printResult(result, cordinate, points);
}
public static double distance(double x1, double y1, double x2, double y2) {
double x = Math.pow(x2 - x1, 2);
double y = Math.pow(y2 - y1, 2);
return Math.sqrt(x + y);
}
public static double[] nearestPoint(double[] cordinate, double[][] points) {
int x = 0;
int y = 1;
double[] nearestCordinates = new double[points.length];
double[] nearestPoint = points[0];
double closest = distance(cordinate[x], cordinate[y], points[0][x], points[0][y]);
nearestCordinates[0] = closest;
double[][] temp = new double[1][2];
for (int i = 0; i < points.length; i++) {
double distance = distance(cordinate[x], cordinate[y], points[i][x], points[i][y]);
if (distance != 0.0 && closest < distance) {
nearestCordinates[i] = distance;
} else {
closest = distance;
}
}
return sortCordinates(nearestCordinates);
}
public static void printResult(double[] result, double[] cordinate, double[][] points) {
int x = 0;
int y = 1;
int count = 0;
double[] res= new double[x+1];
System.out.println("Nearest points are");
for (int i = 0; i < result.length; i++) {
if (result[i] != 0.0) {
res = checkDistance(result[i], cordinate, points);
System.out.println(res[x]+"\t"+ res[y]);
count++;
if (count == 3) {
break;
}
}
}
}
public static double[] sortCordinates(double[] cordinate) {
double temp = 0;
for (int i = 0; i < cordinate.length; i++) {
for (int j = 0; j < cordinate.length - 1; j++) {
if (cordinate[j] > cordinate[j + 1]) {
temp = cordinate[j];
cordinate[j] = cordinate[j + 1];
cordinate[j + 1] = temp;
}
}
}
return cordinate;
}
public static double[] checkDistance(double cordinateDist, double[] cordinate, double[][] points) {
int x = 0;
int y = 1;
for (int i = 0; i < points.length; i++) {
double dist = distance(cordinate[x], cordinate[y], points[i][x], points[i][y]);
if (dist == cordinateDist) {
return points[i];
}
}
return null;
}
}