import java.util.Scanner;

public class StudentGradeCalculator {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = getPositiveInteger();
        
        // Array to store marks for each subject
        int[] marks = new int[numberOfSubjects];
        
        // Input: Marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("Enter marks obtained in subject %d (out of 100): ", i + 1);
            marks[i] = getValidMarks();
        }
        
        // Calculate total marks
        int totalMarks = calculateTotalMarks(marks);
        
        // Calculate average percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        
        // Determine grade
        String grade = determineGrade(averagePercentage);
        
        // Display results
        displayResults(totalMarks, averagePercentage, grade);
    }
    
    private static int getPositiveInteger() {
        int number;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next(); // clear invalid input
            }
            number = scanner.nextInt();
            if (number > 0) {
                break;
            } else {
                System.out.println("Number must be positive. Please enter again.");
            }
        }
        return number;
    }
    
    private static int getValidMarks() {
        int marks;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter marks as an integer.");
                scanner.next(); // clear invalid input
            }
            marks = scanner.nextInt();
            if (marks >= 0 && marks <= 100) {
                break;
            } else {
                System.out.println("Marks must be between 0 and 100. Please enter again.");
            }
        }
        return marks;
    }
    
    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }
    
    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }
    
    private static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
    
    private static void displayResults(int totalMarks, double averagePercentage, String grade) {
        System.out.printf("Total Marks: %d%n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.printf("Grade: %s%n", grade);
    }
}
