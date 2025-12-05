import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the school name: ");
        String schoolName = input.nextLine();

        System.out.print("Enter the teacher's name: ");
        String teacherName = input.nextLine();

        System.out.print("Enter the grade: ");
        int grade = input.nextInt();

        System.out.print("Enter the year: ");
        int year = input.nextInt();

        System.out.print("How many report cards would you like to generate?");
        int reportCardNumber = input.nextInt();

        String[] studentNames = new String[reportCardNumber];
        double[] englishGrades = new double[reportCardNumber];
        double[] mathGrades = new double[reportCardNumber];
        double[] historyGrades = new double[reportCardNumber];
        double[] geographyGrades = new double[reportCardNumber];
        double[] scienceGrades = new double[reportCardNumber];
        double[] programmingGrades = new double[reportCardNumber];

        for(int i = 0; i < reportCardNumber; i++){

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
        for(int i = 0; i < reportCardNumber; i++){
            totalGrades[i] = englishGrades[i] + mathGrades[i] + historyGrades[i] +
                    geographyGrades[i] + scienceGrades[i] + programmingGrades[i];
        }

        String[] Ranks = new String[reportCardNumber];
        int totalAs = 0, totalBs = 0, totalCs = 0, totalDs = 0, totalFs = 0;

        for(int i = 0; i < reportCardNumber; i++){
            if(totalGrades[i] >= 540.0){
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
            } else{
                Ranks[i] = "F";
                totalFs++;
            }
        }

        double[] completeTotals = new double[7];
        double[] completeTotalsAverage = new double[7];
        for(int i = 0; i < reportCardNumber; i++){
            completeTotals[0] += englishGrades[i];
            completeTotals[1] += mathGrades[i];
            completeTotals[2] += historyGrades[i];
            completeTotals[3] += geographyGrades[i];
            completeTotals[4] += scienceGrades[i];
            completeTotals[5] += programmingGrades[i];
            completeTotals[6] += totalGrades[i];
        }

        for(int i = 0; i <= reportCardNumber; i++){
            completeTotalsAverage[i] = completeTotals[i] / reportCardNumber;
        }

        String minusSeparator = "-------------------------------------------------------------------\n";
        String title = "School Name: " + schoolName + '\n' +
                "Teacher: " + teacherName + '\n' +
                "Grade: " + grade + '\n' +
                "Year: " + year + '\n';
        String equalsSeparator = "===================================================================\n";
        String header = equalsSeparator +
                "Student Name\t\t\tEnglish\t\tMath\t\tHistory\t\tGeography\t\tScience\t\tProgramming\t\tTotal\t\tRank" +
                equalsSeparator + '\n';

        System.out.print(minusSeparator + title + header);
        for(int i = 0; i < reportCardNumber; i++){
            System.out.printf("%-20s %.2f  %.2f  %.2f  %.2f  %.2f  %.2f  %.2f %s\n",
                    studentNames[i], englishGrades[i], mathGrades[i], historyGrades[i],
                    geographyGrades[i], scienceGrades[i], programmingGrades[i], totalGrades[i], Ranks[i]);
        }

        System.out.print(minusSeparator);
        System.out.println("\t\t\t\t\t" + completeTotals[0] + "\t" + completeTotals[1] + "\t" +
                completeTotals[2] + "\t" + completeTotals[3] + "\t" + completeTotals[4] + "\t" +
                completeTotals[5] + "\t" + completeTotals[6]);
        System.out.print(minusSeparator);

        System.out.println("\t\t\t\t\t" + completeTotalsAverage[0] + "\t" + completeTotalsAverage[1] + "\t" +
                completeTotalsAverage[2] + "\t" + completeTotalsAverage[3] + "\t" + completeTotalsAverage[4] + "\t" +
                completeTotalsAverage[5] + "\t" + completeTotalsAverage[6]);

        System.out.print(equalsSeparator);
        System.out.print("\t\t\t\tRanks\t\tA's: " + totalAs + "\t\tB's: " + totalBs + "\t\tC's: " +
        totalCs +  "\t\tD's: " + totalDs + "\t\tF's: " + totalFs);

    }
}