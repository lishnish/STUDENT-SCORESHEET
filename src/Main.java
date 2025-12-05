import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the school name: ");
        String schoolName = input.nextLine();

        System.out.println("Enter the teacher's name: ");
        String teacherName = input.nextLine();

        System.out.println("Enter the grade: ");
        int grade = input.nextInt();

        System.out.println("Enter the year: ");
        int year = input.nextInt();

        System.out.println("How many report cards would you like to generate?");
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
            System.out.println("Enter the student's name(id " + (i + 1) + "): ");
            studentNames[i] = input.nextLine();

            System.out.println("Enter the English grade (id " + (i + 1) + "): ");
            englishGrades[i] = input.nextDouble();

            System.out.println("Enter the Math grade (id " + (i + 1) + "): ");
            mathGrades[i] = input.nextDouble();

            System.out.println("Enter the History grade (id " + (i + 1) + "): ");
            historyGrades[i] = input.nextDouble();

            System.out.println("Enter the Geography grade (id " + (i + 1) + "): ");
            geographyGrades[i] = input.nextDouble();

            System.out.println("Enter the Science grade (id " + (i + 1) + "): ");
            scienceGrades[i] = input.nextDouble();

            System.out.println("Enter the Programming grade (id " + (i + 1) + "): ");
            programmingGrades[i] = input.nextDouble();
        }

        double[] totalGrades = new double[reportCardNumber];
        for(int i = 0; i < reportCardNumber; i++){
            totalGrades[i] = englishGrades[i] + mathGrades[i] + historyGrades[i] + geographyGrades[i] + scienceGrades[i] + programmingGrades[i];
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

        for(int i = 0; i < 7; i++){
            completeTotalsAverage[i] = completeTotals[i] / reportCardNumber;
        }

        String minusSeparator =  "--------------------------------------------------------------------------------------------------------------------\n";
        String equalsSeparator = "====================================================================================================================\n";
        String title = "\t\t\t\t\t\t\t\t School Name: " + schoolName + '\n' +
                       "\t\t\t\t\t\t\t\t     Teacher: " + teacherName + '\n' +
                       "\t\t\t\t\t\t\t\t       Grade: " + grade + '\n' +
                       "\t\t\t\t\t\t\t\t        Year: " + year + '\n';

        String header = equalsSeparator +
                "Student Name\t\tEnglish\t\tMath\t\tHistory\t\tGeography\t\tScience\t\tProgramming\t\tTotal\t\tRank" +'\n' +
                equalsSeparator;

        System.out.print(minusSeparator + title + header);
        for(int i = 0; i < reportCardNumber; i++){
            System.out.println(
                    String.format("%-19s", studentNames[i]) + " " +
                            String.format("%.2f", englishGrades[i]) + "\t\t" +
                            String.format("%.2f", mathGrades[i]) + "\t\t" +
                            String.format("%.2f", historyGrades[i]) + "\t\t" +
                            String.format("%.2f", geographyGrades[i]) + "\t\t\t" +
                            String.format("%.2f", scienceGrades[i]) + "\t\t" +
                            String.format("%.2f", programmingGrades[i]) + "\t\t\t" +
                            String.format("%.2f", totalGrades[i]) + "\t\t" +
                            Ranks[i]
            );
        }

        System.out.print(minusSeparator);

        System.out.println(
                "\t\t\t\t\t" + String.format("%.2f", completeTotals[0]) + "\t\t" + String.format("%.2f", completeTotals[1]) + "\t\t" +
                        String.format("%.2f", completeTotals[2]) + "\t\t" + String.format("%.2f", completeTotals[3]) + "\t\t\t" + String.format("%.2f", completeTotals[4]) + "\t\t" +
                        String.format("%.2f", completeTotals[5]) + "\t\t\t" + String.format("%.2f", completeTotals[6])
        );

        System.out.print(minusSeparator);

        System.out.println(
                "\t\t\t\t\t" + String.format("%.2f", completeTotalsAverage[0]) + "\t\t" + String.format("%.2f", completeTotalsAverage[1]) + "\t\t" +
                        String.format("%.2f", completeTotalsAverage[2]) + "\t\t" + String.format("%.2f", completeTotalsAverage[3]) + "\t\t\t" + String.format("%.2f", completeTotalsAverage[4]) + "\t\t" +
                        String.format("%.2f", completeTotalsAverage[5]) + "\t\t\t" + String.format("%.2f", completeTotalsAverage[6])
        );

        System.out.print(equalsSeparator);

        System.out.println(
                "\t\t\t\t\tRanks\t\tA's: " + totalAs + "\t\tB's: " + totalBs + "\t\tC's: " +
                totalCs +  "\t\tD's: " + totalDs + "\t\tF's: " + totalFs);
    }
}
