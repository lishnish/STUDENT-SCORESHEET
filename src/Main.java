import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        String minusSeparator = "--------------------------------------------------------------------------------------------------------------------\n";
        String equalsSeparator = "====================================================================================================================\n";
        String header = equalsSeparator +
                "Student Name\t\t\tEnglish\t\t  Math\t\tHistory\t\tGeography\tScience\t\tProgramming\t\tTotal\t   Rank" + '\n' +
                equalsSeparator + '\n';

        boolean debug = true;
        if (!debug) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the school name: ");
            String schoolName = input.nextLine();

            System.out.print("Enter the teacher's name: ");
            String teacherName = input.nextLine();

            System.out.print("Enter the grade: ");
            int grade = input.nextInt();

            System.out.print("Enter the year: ");
            int year = input.nextInt();

            System.out.print("How many report cards would you like to generate? ");
            int reportCardNumber = input.nextInt();

            String[] studentNames = new String[reportCardNumber];
            double[] englishGrades = new double[reportCardNumber];
            double[] mathGrades = new double[reportCardNumber];
            double[] historyGrades = new double[reportCardNumber];
            double[] geographyGrades = new double[reportCardNumber];
            double[] scienceGrades = new double[reportCardNumber];
            double[] programmingGrades = new double[reportCardNumber];

            for (int i = 0; i < reportCardNumber; i++) {

                input.nextLine(); //Consume whitespace
                System.out.print("Enter the student's name(id " + (i + 1) + "): ");
                studentNames[i] = input.nextLine();

                System.out.print("Enter the English grade (id " + (i + 1) + "): ");
                englishGrades[i] = input.nextDouble();

                System.out.print("Enter the Math grade (id " + (i + 1) + "): ");
                mathGrades[i] = input.nextDouble();

                System.out.print("Enter the History grade (id " + (i + 1) + "): ");
                historyGrades[i] = input.nextDouble();

                System.out.print("Enter the Geography grade (id " + (i + 1) + "): ");
                geographyGrades[i] = input.nextDouble();

                System.out.print("Enter the Science grade (id " + (i + 1) + "): ");
                scienceGrades[i] = input.nextDouble();

                System.out.print("Enter the Programming grade (id " + (i + 1) + "): ");
                programmingGrades[i] = input.nextDouble();
            }

            double[] totalGrades = new double[reportCardNumber];
            for (int i = 0; i < reportCardNumber; i++) {
                totalGrades[i] = englishGrades[i] + mathGrades[i] + historyGrades[i] +
                        geographyGrades[i] + scienceGrades[i] + programmingGrades[i];
            }

            String[] Ranks = new String[reportCardNumber];
            int totalAs = 0, totalBs = 0, totalCs = 0, totalDs = 0, totalFs = 0;

            for (int i = 0; i < reportCardNumber; i++) {
                if (totalGrades[i] >= 540.0) {
                    Ranks[i] = "A";
                    totalAs++;
                } else if (totalGrades[i] >= 480.0 && totalGrades[i] < 540.0) {
                    Ranks[i] = "B";
                    totalBs++;
                } else if (totalGrades[i] >= 420.0 && totalGrades[i] < 480.0) {
                    Ranks[i] = "C";
                    totalCs++;
                } else if (totalGrades[i] >= 360.0 && totalGrades[i] < 420.0) {
                    Ranks[i] = "D";
                    totalDs++;
                } else {
                    Ranks[i] = "F";
                    totalFs++;
                }
            }

            int subjectNumber = 6;
            double[] completeTotals = new double[subjectNumber + 1];
            double[] completeTotalsAverage = new double[subjectNumber + 1];
            for (int i = 0; i < reportCardNumber; i++) {
                completeTotals[0] += englishGrades[i];
                completeTotals[1] += mathGrades[i];
                completeTotals[2] += historyGrades[i];
                completeTotals[3] += geographyGrades[i];
                completeTotals[4] += scienceGrades[i];
                completeTotals[5] += programmingGrades[i];
                completeTotals[6] += totalGrades[i];
            }

            for (int i = 0; i <= subjectNumber; i++) {
                completeTotalsAverage[i] = completeTotals[i] / reportCardNumber;
            }

            String title = "\t\t\t\t\t\t\t\t\t\tSchool Name: " + schoolName + '\n' +
                    "\t\t\t\t\t\t\t\t\t\t\tTeacher: " + teacherName + '\n' +
                    "\t\t\t\t\t\t\t\t\t\t\t  Grade: " + grade + '\n' +
                    "\t\t\t\t\t\t\t\t\t\t\t\t Year: " + year + '\n';

            System.out.print(minusSeparator + title + header);
            for (int i = 0; i < reportCardNumber; i++) {
                System.out.printf("%-20s\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t\t%.2f\t\t %.2f\t\t %s\n",
                        studentNames[i], englishGrades[i], mathGrades[i], historyGrades[i],
                        geographyGrades[i], scienceGrades[i], programmingGrades[i], totalGrades[i], Ranks[i]);
            }

            System.out.print(minusSeparator);
            System.out.println("\t\t\t\t\t   " + completeTotals[0] + "\t\t" + completeTotals[1] + "\t\t" +
                    completeTotals[2] + "\t " + completeTotals[3] + "\t  " + completeTotals[4] + "\t   " +
                    completeTotals[5] + "\t\t " + completeTotals[6]);
            System.out.print(minusSeparator);

            System.out.println("\t\t\t\t\t\t" + completeTotalsAverage[0] + "\t\t" + completeTotalsAverage[1] + "\t\t" +
                    completeTotalsAverage[2] + "\t\t" + completeTotalsAverage[3] + "\t\t\t" + completeTotalsAverage[4] + "\t\t" +
                    completeTotalsAverage[5] + "\t\t " + completeTotalsAverage[6]);

            System.out.print(equalsSeparator);
            System.out.print("\t\t\t\tRanks\t\tA's: " + totalAs + "\t\tB's: " + totalBs + "\t\tC's: " +
                    totalCs + "\t\tD's: " + totalDs + "\t\tF's: " + totalFs);
            return;
        }
        System.out.print(minusSeparator);
        System.out.print("\t\t\t\t\t\t\t\t\t\tSchool Name: Ronald Reagan High School\n" +
                "\t\t\t\t\t\t\t\t\t\t\tTeacher: Mr. Paul Swatz\n" +
                "\t\t\t\t\t\t\t\t\t\t\t  Grade: 10\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t Year: 2018\n");
        System.out.print(header);
        System.out.printf("%-20s\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t\t%.2f\t\t %.2f\t\t %s\n", "Loyola Ingenious", 98.00, 87.90, 91.00, 89.00, 90.00, 94.00, 549.90, "A");
        System.out.print(minusSeparator);
        System.out.println("\t\t\t\t\t   1154.20\t\t1205.50\t\t 1213.10\t 1244.90\t  1207.10\t   1180.70\t\t 7205.50");
        System.out.print(minusSeparator);
        System.out.print("\t\t\t\t\t\t76.95\t\t80.37\t\t 80.87\t\t 82.99\t\t\t80.47\t\t78.71\t\t 480.37\n");
        System.out.print(equalsSeparator);
    }
}