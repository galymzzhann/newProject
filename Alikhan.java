import java.util.Scanner;

public class Alikhan {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        greeting();
        travelTime();
        timeDiff();
        countryArea();
        nextDestination();
    }
    public static String destination;
    public static void greeting() {
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = scan.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you traveling to? ");
        destination = scan.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip");
    }

    public static void travelTime() {
        System.out.print("How many days are you going to spend traveling? ");
        int days = scan.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip: ");
        double money = scan.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String crn = scan.next();
        System.out.print("How many " + crn + " are there in USD? ");
        String s = scan.next();
        double convert = Double.parseDouble(s);
        int hours = days * 24;
        int minutes = hours * 60;
        int seconds = minutes * 60;
        double perday = money / days;
        double converted = Math.round((convert * money) * 100 / 100.0);
        double pday = converted / days;
        System.out.println("If you are traveling for " + days + " days" + " that is same as " + hours + " hours" + " or " + minutes + " minutes" + " or " + seconds + " seconds");
        System.out.println("If you are going to spend " + money + " USD " + "that means per day you can spend up to " + Math.round(perday * 100) / 100.0 + " USD");
       System.out.println("Your total budget in EUR is " + converted + " EUR, which per day is " + Math.round(pday * 100) / 100.0 + " EUR");
    }

    public static void timeDiff() {
        System.out.print("What is the time difference, in hours, between your home and " + destination + "? ");
        int difference = scan.nextInt();
        int midnight = 0;
        int noon = 0;
        if (difference > 0 && difference < 24) {
            midnight = difference;
            noon = (midnight + 12) % 24;
        }
        if (difference > 23) {
            midnight = difference % 24;
            noon = (midnight + 12) % 24;
        }
        if (difference < 0 && difference > -25) {
            midnight = 24 + difference;
            noon = Math.abs(12 + difference);
        }
        if (difference <= -25) {
            midnight = (Math.abs(difference) % 24);
            noon = Math.abs(12 - (Math.abs(difference) % 24));
        }
        if (difference < 0 && Math.abs(difference % 24) == 0) {
            midnight = 0;
            noon = 12;
        }
        System.out.println("That means that when it is midnight at home it will be " + midnight +":00 in " + destination + " and when it is noon at home it will be " + noon + ":00");
    }

    public static void countryArea() {
        System.out.print("What is square area of your destination country in km2? ");
        int km = scan.nextInt();
        double mil = km * 0.38610215854245;
        System.out.print("In miles2 that is " + Math.round(mil * 100) / 100.0);
        System.out.println();
    }

    public static void nextDestination() {
        System.out.print("How many places you traveled to : ");
        int a = scan.nextInt();
        String[] arr = new String[a];
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            System.out.print("Enter the name: ");
            arr[i] = scan.nextLine();
        }
        System.out.println("Next place you want to travel to : ");
        String[] pattern = {"France", "South Korea", "England", "Italy", "Kazakhstan", "Qatar", "Japan", "USA", "Brazil", "Turkey", "Egypt", "South Africa", "Spain", "Russia", "Canada", "China", "Poland", "Portugal", "Argentina", "Switzerland", "Mexico", "Ukraine", "UK", "Georgia", "India", "Australia"};
        String[] recommendations = new String[5];
        int count = 0;
        int[] indexes = new int[a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if(arr[i].equals(pattern[j])){
                    indexes[count] = j;
                    count++;
                }
            }
        }
        int count2 = 0;
        for(int i=0; i<indexes.length; i++){
            for(int j=0; j<pattern.length; j++){
                if(indexes[i]==j){
                    pattern[j] = "";
                }
            }
        }
        for(int i=0; i<pattern.length; i++){
            if(!pattern[i].equals("")){
                recommendations[count2]=pattern[i];
                count2++;
            }
            if(count2==5){
                break;
            }
        }
        for(int i =0; i<recommendations.length; i++){
            System.out.println(i + ": "+recommendations[i]);
        }
        System.out.print("Write index of country : ");
        int index = scan.nextInt();
        System.out.println("Thank you, Your next location is : " + recommendations[index]);
    }
}
