package tournament;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tournament
{
    @SuppressWarnings("UseOfObsoleteCollectionType")                //Δήλωση μεταβλητών.
    static Vector<String>name = new Vector<>();
    static Vector<String>nickname = new Vector<>();
    static Vector<String>mail = new Vector<>();
    static Vector<String>playgame = new Vector<>();
    static Vector<String> name_game = new Vector<>();
    static Vector<String> type = new Vector<>();
    static Vector<Integer> max_num = new Vector<>();
    static Vector<Date> game_date = new Vector<>();
    static Vector<Date> time = new Vector<>();
    static Vector<String> game_place = new Vector<>();
    static Vector<String> moderator = new Vector<>();
    static Vector<Integer> duration = new Vector<>();
    static int j = 0;
    static int check;
    static int i = -1;
    static String game;
    static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    static DateFormat tf = new SimpleDateFormat("HH:mm");
    static Moderators ts = new Moderators();
    
    public static void main(String[] args)
    {
        ts.setPh_number(123);                   //Δημιουργία αρχικού moderator για όλα τα παιχνίδια
        ts.setMmail("Tsadimas@hua.gr");
        ts.setNickname("Tsadimas");
        ts.setName("Argiris");
        name_game.add("Hearthstone");           //Δημιουργία αρχικού παιχνιδιού 
        type.add("Turn Based");
        max_num.add(32);
        try {
            game_date.add(df.parse("2/01/15"));
        } catch (ParseException ex) {
           
        }
        try {
            time.add(tf.parse("12:00"));
        } catch (ParseException ex) {
          
        }
        game_place.add("2.1");
        moderator.add(ts.getNickname());
        duration.add(42);
        Menu();                                  //Κάλεσμα της μεθόδου που εμφανίζει τις βασικές επιλογές
    }

    private static void Menu()                   //Εμφάνιση επιλογών και ανακατεύθυνση.
    {
        System.out.print("  ______________________\n |\t  MENU\t\t| "           
            + "\n |    1. Manage Players | "
            + "\n |    2. Manage Games   | "
            + "\n |    3. Info           | "
            + "\n |    Q. Quit           | "
            + "\n |______________________| "
            + "\n  Choose: ");

        Scanner input = new Scanner(System.in);
        String choice;
        choice = input.nextLine();
        while(!choice.equalsIgnoreCase("Q"))
        {
            switch(choice)
            {
                case "1":
                    Games();
                break;
                case "2":
                    Manage_Games();
                break;
                case "3":
                    Info();
                break;
                default:
                    System.err.println("Wrong choice try again!!");
                    System.out.print("\n  Choose: ");
                    choice = input.nextLine();
                break;
            }
        }
        Quit();
    }

    private static void Games()             //Εμφάνιση των παιχνιδιών που υπάρχουν στο σύστημα, ή δημιουργία καινούριου αν δεν υπάρχει.
    {
        if(name_game.isEmpty()){
            System.out.println("\nAdd Game");
            Add_Games();
        }
        else if(!name_game.isEmpty()){
            int x,y = j;
            for(x=0; x<=y; x++)
            {
                if((x % 2) == 0){
                    System.out.println("");
                }
                else{
                }
                int b = x+1;
                System.out.print(b+". ");
                System.out.print(name_game.get(x));
                String a = name_game.get(x);
                int space = a.length()-20;
                for(int k=Math.abs(space); k>=1; k--)
                {
                    System.out.print(" ");
                }
            }
        }
        if((j % 2) == 0 ){
        System.out.print("B. Back"
            +"\n  Choose: ");
        }
        else{
            System.out.print("\nB. Back\n  Choose: ");
        }
        Scanner input = new Scanner(System.in);
        String choice;
        choice = input.nextLine();
        try
        {
           
            while(!choice.equalsIgnoreCase("B"))
            {
                int l = Integer.parseInt(choice);
                for(int a=0; a<=j+1;)
                {
                    if(a == l){
                        game = (name_game.get(l-1));
                        Manage_Players();
                    }
                    if(a==j+1){
                        System.err.println("Wrong choice try again!!");
                        choice = input.nextLine();
                    }
                    a++;
                }
            }
            Menu();
        }
        catch(NumberFormatException e){
            Error();
                
        }
     
    }

    private static void Manage_Players()                  //Διαχείριση παικτών του παιχνιδιού που διάλεξε ο χρήστης στο προηγούμενο μενού. 
    {
        System.out.print("\n  "+game+" "
            +"\n1. Add Players"
            +"\n2. Delete Players"
            +"\n3. Edit Players"
            +"\n4. View"
            +"\n5. Matchmaking"
            +"\nB. Back"
            +"\n  Choose: ");

        Scanner input = new Scanner(System.in);
        String choice;
        choice = input.nextLine();
        while(!choice.equalsIgnoreCase("B"))
        {
            switch(choice)
            {
                case "1":
                    Add_Players();
                break;
                case "2":
                    Delete_Players();
                break;
                case "3":
                    Edit_Players();
                break;
                case "4":
                    View_Players();
                break;
                case "5":
                    Match_Making();
                break;
                default:
                    System.err.println("Wrong choice try again!!");
                    System.out.print("  Choose: ");
                    choice = input.nextLine();
                break;
            }
        }
        Menu();
    }

   

        private static void Add_Players()
        {
            Players player = new Players();
            i++;
            System.out.print("\n  Enter nickname: ");
                Scanner ob2 = new Scanner(System.in);
                player.nickname = ob2.nextLine();
                nickname.add(player.nickname);
                if(i>0){
                    for(int k=0; k<i; k++)
                    {
                        String ni = nickname.get(k);
                        if((nickname.get(i)).equalsIgnoreCase(ni)){
                            nickname.remove(k);
                            i--;
                            System.err.println("Nickname already exists.");
                            Add_Players();
                        }
                    }
                }
                System.out.print("  Enter name: ");
                Scanner ob1 = new Scanner(System.in);
                player.name = ob1.nextLine();
                name.add(player.name);
                do{
                    check=0;
                    System.out.print("  Enter mail: ");
                    Scanner ob3 = new Scanner(System.in);
                    player.mail = ob3.nextLine();
                    Boolean elenxos = EmailFormatValidator(player.mail);
                    if(elenxos==true){
                        mail.add(player.mail);
                        check=1;
                    }
                    else{
                        System.err.println("Wrong email try again!!");
                    }
                }while(check==0);
                playgame.add(game);
                System.out.println("\nAdd other player? Yes/No");
                YesNo();
                Add_Players();
        }

        private static void Delete_Players()
        {
            Empty2();
            int code,s;
            String nick;
            System.out.print("\n  Enter Nickname: ");
            Scanner ob = new Scanner(System.in);
            nick = ob.nextLine();
            code = 0;
            s = i;
            boolean control = false;
            do
            {
                if(nick.equalsIgnoreCase(nickname.get(code))){
                    if(playgame.get(code).equals(game)){
                        control = true;
                        System.err.println("Are you sure? Yes/No");
                        YesNo();
                        name.removeElementAt(code);
                        nickname.remove(code);
                        mail.remove(code);
                        playgame.remove(code);
                        s--;
                        System.out.println("\n        DONE!");
                    }
                    else{
                        System.out.println("Player exist in other game");
                        Back_Quit();
                        Manage_Players();
                    }
                    break;
                }
                code++;
            }
            while(code <= i);
            if(control == false){
                System.out.println("Nickname does not exist"
                    +"\n1.Try again\t B.Back");
                System.out.print("  Choose: ");
                Scanner ch = new Scanner(System.in);
                 String chi= ch.nextLine();
                switch (chi) {
                    case "1":
                        Delete_Players();
                        break;
                    case "B":
                        Manage_Players();
                        break;
                    case "b":
                        Manage_Players();
                        break;
                    default:
                        Error();
                        break;
                }
            }
            i = s;
            Empty2();
            System.out.println("\nDelete other player? Yes/No");
            YesNo();
            Manage_Players();
        }

        private static void Edit_Players()                //Δυνατότητα αλλαγής στοιχείων ενός συγκεκριμένου παίκτη.
        {
            Empty2();
            int code,p;
            String nick;
            System.out.print("\n  Enter Nickname: ");
            Scanner ob = new Scanner(System.in);
            nick = ob.nextLine();
            code = 0;
          
             
            boolean control = false;
            
            do
            {
                do
                {
                    p=0;
               
                    if(nick.equalsIgnoreCase(nickname.get(code))){
                        if(playgame.get(code).equals(game)){
                            control = true;
                        System.out.print("\nWhat do you want to modify?"
                            +"\n1. Name"
                            +"\n2. Nickname"
                            +"\n3. Mail"
                            +"\nB. Back"
                            +"\n  Choose: ");

                        Scanner input = new Scanner(System.in);
                        String choice;
                         choice = input.nextLine();
                        if(!choice.equalsIgnoreCase("B"))
                        {
                            switch(choice)
                            {
                                case "1":
                                    System.out.print("\n  Enter new name: ");
                                    String new_name = input.nextLine();
                                    name.set(code,new_name);
                                break;
                                case "2":
                                    System.out.print("\n  Enter new nickname: ");
                                    int x,y = i;
                                    x = -1;
                                    String new_nick = input.nextLine();
                                    do
                                    {
                                        x++;
                                        if(new_nick.equalsIgnoreCase(nickname.get(x))){
                                            System.out.print("\n Nickname already exists."
                                                +"\n  Enter new nickname: ");
                                            new_nick = input.nextLine();
                                            x = -1;
                                        }
                                        else if(x == y){
                                            nickname.set(code,new_nick);
                                            x = y+1;
                                        }
                                    }
                                    while(x<= y);
                                break;
                                case "3":
                                    do{
                                        check=0;
                                        System.out.print("\n  Enter new mail: ");
                                        String new_mail = input.nextLine();
                                        Boolean elenxos = EmailFormatValidator(new_mail);
                                        if(elenxos==true){
                                            mail.set(code,new_mail);
                                            check=1;
                                        }
                                        else{
                                            System.err.println("Wrong email try again!!");
                                        }
                                    }while(check==0);
                                break;
                                default:
                                    Error();
                                    code = ob.nextInt();
                                break;
                            }
                            
                            System.out.println("\n        DONE!");
                            System.out.println("\nNew Modify? Yes/No");
                            YesNo();
                            p=1;
                 
                        }else{
                            Menu();
                        }
                        }
                          else{
                        System.out.println("Player exist in other game");
                        Back_Quit();
                        Manage_Players();
                    }
              } 
                    }while(p==1);
                   
                
                code++;
            }
            while(code <= i);
                    
         
            if(control == false)
            {
                System.out.println("Nickname does not exist"
                    +"\nTry again");
                Edit_Players();
            }
        }

        private static void View_Players()          //Εμφάνισης της λίστας των παικτών του παιχνιδιού
        {
            Empty2();
            int x,y = i;
            int z=0;
            for(x=0; x<=y;)
            {
                if(playgame.get(x).equalsIgnoreCase(game)){
                    z++;
                }
                 x++;
            }
            if(z==0){
                System.out.println("\nlist is Empty");
            }
            else{
                int w = j;
                for(x=0; x<=w;)
                {
                    if(name_game.get(x).equalsIgnoreCase(game)){
                    System.out.println("                                        Moderator"
                        +"\n                                           "+moderator.get(x));
                    }
                    x++;
                }
                System.out.println("\nName\tNickname\tMail\t\tGames");
                for(x=0; x<=y;)
                {
                    if(playgame.get(x).equalsIgnoreCase(game)){
                        System.out.print(name.get(x));
                        System.out.print("\t");
                        
                        System.out.print(nickname.get(x));
                        System.out.print("\t\t");
                        
                        System.out.print(mail.get(x));
                        System.out.print("\t");
                        
                        System.out.println(playgame.get(x));
                    }
                    x++;
                }
            }
            Back_Quit();
            Manage_Players();
        }

        private static void Match_Making()            //Μέθοδος που ελέγχει αν υπάρχει άρτιος αριθμός παικτών και συνεχίζει στην Match_Pairs(). 
        {
            Empty2();
            if((nickname.size()<2)){
                System.out.println("\nThere are no pairs");
                Back_Quit();
                Manage_Players();
            }
            System.out.println("\nThe number of the registrations for "+game+": "+nickname.size());
            Power_Of_Two(nickname.size());
            Match_Pairs();
            Manage_Players();
        }

      

    private static void Manage_Games()                  //Διαχείριση των παιχνιδιών του συστήματος.
    {
        System.out.print("\n1. Add Games"
            +"\n2. Delete Games"
            +"\n3. Edit Games"
            +"\n4. View"
            +"\nB. Back"
            +"\n  Choose: ");

        Scanner input = new Scanner(System.in);
        String choice;
        choice = input.nextLine();
        while(!choice.equalsIgnoreCase("B"))
        {
            switch(choice)
            {
                case "1":
                    Add_Games();
                break;
                case "2":
                    Delete_Games();
                break;
                case "3":
                    Edit_Games();
                break;
                case "4":
                    View_Games();
                break;
                default:
                    System.err.println("Wrong choice try again!!");
                    choice = input.nextLine();
                break;
            }
        }
        Menu();
    }

        private static void Add_Games()             //Εισαγωγή νέων παιχνιδιών στο σύστημα.
        {
            Games games = new Games();
            j++;
            System.out.print("\n  Enter Title: ");
            Scanner ob = new Scanner(System.in);
            games.name_game=ob.nextLine();
            name_game.add(games.name_game);
            if(j>0){
                for(int k=0; k<j; k++)
                {
                    String ni = name_game.get(k);
                    if((name_game.get(j)).equalsIgnoreCase(ni)){
                        name_game.remove(k);
                        j--;
                        System.err.println("Game already exists.");
                        Add_Games();
                    }
                }
            }
            System.out.print("1. Time Based\t2. Turn Based"
                +"\n  Choose: ");
            int s;
            try
            {
                do
                {
                    Scanner input = new Scanner(System.in);
                    String m;
                    m = input.nextLine();
                    s = Integer.parseInt(m.trim());
                    if(s == 1){
                        type.add("Time Based");
                        System.out.print("  Give the maximum time duration of a match \n  Enter Time: ");
                        duration.add(input.nextInt());
                        
                    }
                    else if(s == 2){
                        type.add("Turn Based");
                        System.out.print("  Give the maximum turn duration of a match \n  Enter Turns: ");
                        duration.add(input.nextInt());
                    }
                    else{
                        System.err.println("Wrong choice try again!!");
                    }
                }
                while(s<1 || s>2);
            }
            catch (NumberFormatException e)
            {
                System.err.println("An error occurred, please try again.");
                j--;
                Add_Games();
            }
            System.out.print("  Enter max players 2-64: ");
            try
            {
                do
                {   
                    check=0;
                    Scanner input = new Scanner(System.in);
                    int h = input.nextInt();
                    if(h>=2 && h<=64){
                        max_num.add(h);
                        check=1;
                    }
                    else{
                        System.err.println("Wrong choice try again!!");
                    }
                }
                while(check==0);
            }
            catch (NumberFormatException e){
            }
            do{
                check=0;
                System.out.print("  Enter the date of the game (Date type dd/MM/yyyy and between 23/12/2014 and 07/01/2015 dates):");
                Scanner ob4 = new Scanner(System.in);
                String tdate = ob4.nextLine();
                Date ndate= new Date();
                Date date1 = new Date();
                Date date2 = new Date();
                try {
                    ndate = df.parse(tdate);
                    date1 = df.parse("22/12/2014");
                    date2 = df.parse("08/01/2015");
                } catch (ParseException e) {
                }
                
                if(ndate.before(date2) && ndate.after(date1)){
                    game_date.add(ndate);
                    check=1;
                }
                else{
                    System.err.println("Wrong date!!");
                }
            }
            while(check==0);
            do{
                check=0;
                System.out.print("  Enter the time of the game (Time type HH:mm and between 10:00 and 22:00):");
                Scanner ob5 = new Scanner(System.in);
                String ttime = ob5.nextLine();
                Date ntime= new Date();
                Date time1 = new Date();
                Date time2 = new Date();
                try {
                    ntime = tf.parse(ttime);
                    time1 = tf.parse("10:00");
                    time2 = tf.parse("22:00");
                } catch (ParseException ex) {
           
                }
                if(ntime.after(time1) && ntime.before(time2)){
                    time.add(ntime);
                    check=1;
                }
                else{
                    System.err.println("Wrong time!!");
                }
                
            }while(check==0);
            System.out.print("  Enter the place of the game: ");
                Scanner ob6 = new Scanner(System.in);
                games.game_place = ob6.nextLine();
                game_place.add(games.game_place);
               
                moderator.add(ts.getNickname());
            System.out.println("\nAdd other game? Yes/No");
                YesNo();
                Add_Games();
    }

        private static void Delete_Games()                  //Διαγραφή παιχνιδιών απο το σύστημα.
        {
            Empty3();
            int code;
            int s;
            String title;
            System.out.print("\n  Enter Title: ");
            Scanner ob = new Scanner(System.in);
            title = ob.nextLine();
            code = 0;
            s = j;
            boolean control;
            control = false;
            do
            {
                if(title.equalsIgnoreCase(name_game.get(code))){
                    control = true;
                    System.err.println("Are you sure? Yes/No");
                    YesNo();
                    name_game.removeElementAt(code);
                    type.remove(code);
                    duration.remove(code);
                    max_num.remove(code);
                    game_date.removeElementAt(code);
                    time.remove(code);
                    game_place.remove(code);
                    moderator.remove(code);
                    s--;
                    System.out.println("\n        DONE!");
                    break;
                }
                code++;
            }
            while(code <= j);
            if(control == false){
                System.out.println("Game does not exist."
                    +"\nTry again!");
                Delete_Games();
            }
            j = s;
            Empty3();
            System.out.print("\nDelete other Game? Yes/No\n  ");
            YesNo();
            Delete_Games();
        }

        private static void Edit_Games()                    //Τροποποίηση των υπάρχοντων παιχνιδιών.         
        {
            Empty3();
            int code,p;
            String nick;
            System.out.print("\n  Enter Title: ");
            Scanner ob = new Scanner(System.in);
            nick = ob.nextLine();
            code = 0;
            boolean control = false;
            do
            {
                if(nick.equalsIgnoreCase(name_game.get(code))){
                    do
                    {
                        p=0;
                    
                    System.out.print("\nWhat do you want to modify?"
                        +"\n1. Name"
                        +"\n2. Type"
                        +"\n3. Duration"
                        +"\n4. Max Number"
                        +"\n5. Date"
                        +"\n6. Time"
                        +"\n7. Place"
                        +"\n8. Moderator"
                        +"\nB. Back"
                        +"\n  Choose: ");

                    Scanner input = new Scanner(System.in);
                    String choice;
                    choice = input.nextLine();
                    if(!choice.equalsIgnoreCase("B"))
                    {
                        switch(choice)
                        {
                            case "1":
                                System.out.print("\n  Enter new title: ");
                                 int x,y = j;
                                 x = -1;
                                 String new_name_game = input.nextLine();
                                 do
                                 {
                                     x++;
                                     if(new_name_game.equalsIgnoreCase(name_game.get(x))){
                                         System.out.print("\n Game already exists."
                                             +"\n  Enter new title: ");
                                         new_name_game = input.nextLine();
                                         x = -1;
                                     }
                                     else if(x == y){
                                         name_game.set(code,new_name_game);
                                         x = y+1;
                                     }
                                 }
                                 while(x <= y);
                                 break;
                            case "2":
                                String ni = "Time Based";
                                if(type.get(code).equals(ni)){
                                    type.set(code,"Turn Based");
                                    }
                                else{
                                    type.set(code,"Time Based");
                                }
                            break;
                            case "3":
                                System.out.println("  Enter the new duration of a match: ");
                                duration.set(code,input.nextInt());
                            break;
                            case "4":
                                System.out.print("\n  Enter new max number: ");
                                int new_max_num = input.nextInt();
                                max_num.set(code,new_max_num);
                            break;
                            case "5":
                                do{
                                    check=0;
                                    System.out.print("\n  Enter new date for the game (Date type dd/MM/yyyy and between 23/12/2014 and 07/01/2015 dates):");
                                    Date new_game_date = new Date();
                                    String tdate = input.nextLine();
                                    Date date1 = new Date();
                                    Date date2 = new Date();
                                    try {
                                        new_game_date = df.parse(tdate);
                                        date1 = df.parse("22/12/2014");
                                        date2 = df.parse("08/01/2015");
                                    } catch (ParseException e) {
                                    }

                                    if(new_game_date.before(date2) && new_game_date.after(date1)){
                                        game_date.set(code,new_game_date);
                                        check=1;
                                    }
                                    else{
                                        System.err.println("Wrong date!!");
                                    }
                                }while(check==0);
                            break;
                            case "6":
                                do{
                                    check=0;
                                    System.out.print("  Enter the new time of the game (Time type HH:mm and between 10:00 and 22:00):");
                                    Scanner ob5 = new Scanner(System.in);
                                    String ttime = ob5.nextLine();
                                    Date ntime= new Date();
                                    Date time1 = new Date();
                                    Date time2 = new Date();
                                    try {
                                        ntime = tf.parse(ttime);
                                        time1 = tf.parse("10:00");
                                        time2 = tf.parse("22:00");
                                    } catch (ParseException ex) {
                                        Logger.getLogger(Tournament.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    if(ntime.after(time1) && ntime.before(time2)){
                                        time.add(ntime);
                                        check=1;
                                    }
                                    else{
                                        System.err.println("Wrong time!!");
                                    }

                                }while(check==0);
                            break;
                            case "7":
                                System.out.print("\n  Enter new place for the game: ");
                                String new_game_place;
                                new_game_place = input.nextLine();
                                game_place.set(code,new_game_place);
                            break;
                            case "8":
                                Empty4();
                                int a,b = i;
                                int z=0;
                                for(a=0; a<=b;)
                                {
                                    if(playgame.get(a).equalsIgnoreCase(game)){
                                        z++;
                                    }
                                     a++;
                                }
                                    for(a=0; a<=b;a++){
                                        System.out.print("  Suggested Moderator: "+nickname.get(a));
                                        System.out.print("\n");
                                    }
                                System.out.print("  Insert new moderator: ");
                                moderator.set(code,input.nextLine());
                            break;
                            default:
                                System.err.println("Wrong choice try again!!");
                                code = ob.nextInt();
                            break;
                        }
                        System.out.println("\n        DONE!");
                        System.out.println("\nNew Modify? Yes/No");
                        YesNo();
                        p=1;
                    }
                    
                    else{
                        Manage_Games();
                    }
                    }while(p==1);
                    
                }
                code++;
            }
            while(code <= j);
            if(control == false){
                System.out.println("Game does not exist."
                    +"\nTry again!");
                Edit_Games();
            }
        }

        private static void View_Games()                    //Εμφάνιση της λίστας των παιχνιδιών του συστήματος.
        {
            Empty3();
            int x,y = j;
            System.out.println("\nGame\t\tType\t\tDuration\tMax Players\tDate\t\tTime\tPlace\tModerator");
            for(x=0; x<=y; x++)
            {
                
                System.out.print(name_game.get(x));
                System.out.print("\t");
                if(name_game.get(x).length()<8){
                    System.out.print("\t");
                }


                System.out.print(type.get(x));
                System.out.print("\t");
                
                if(type.get(x).equals("Time Based")){
                    System.out.print(duration.get(x)+" minutes");
                    System.out.print("\t");
                }
                else{
                    System.out.print(duration.get(x)+" turns");
                    System.out.print("\t");
                }
   
                System.out.print(max_num.get(x));
                System.out.print("\t\t");
                
                System.out.print(df.format(game_date.get(x)));
                System.out.print("\t");
                
                System.out.print(tf.format(time.get(x)));
                System.out.print("\t");
                
                System.out.print(game_place.get(x));
                System.out.print("\t");
                
                System.out.print(moderator.get(x)+"\n");
            }
            Back_Quit();
            Manage_Games();
        }

    public static void Info()                   //Βασικές πληροφορίες για τη διεξαγωγή του τουρνουά.
    {
        String Name_Tournament = "Harokopeio Championship Series 4";
        String Starting_Date = "Dec 23th at 10:00 am";
        String Ending_Date = "Jan 07th at 10:00 pm";
        String Tournament_Place = "Harokopeio";

        System.out.println("\n" +Name_Tournament
            + "\n\n · Tournament Location: " +Tournament_Place
            + "\n · Start Date: " +Starting_Date
            + "\n · End Date: " +Ending_Date);
        Back_Quit();
        Menu();
    }

    private static void Back_Quit()                 //Βοηθητική μέθοδος για πλοήγηση στα προηγούμενα μενού και έξοδο από το σύστημα
    {
        System.out.print("\n   B. (<)\tQ. (X)   "
                +"\n  ");
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        while(!option.equalsIgnoreCase("B"))
        {
            switch (option)
            {
                case "Q":
                    Quit();
                break;
                case "q":
                    Quit();
                break;
                default:
                    System.err.println("Wrong choice try again!!");
                    option = input.nextLine();
                break;
            }
        }
    }

    private static void Quit()              //Μέθοδος οριστικής εξόδου απο το σύστημα.
    {
        System.err.println("Are you sure Yes/No?");
        YesNo();
        System.exit(0);
    }

    private static void Error()         //Βοηθητική μέθοδος για την περίπτωση που ο χρήστης κάνει λάθος επιλογή.
    {
        System.err.println("Not an option, please try again.");
        System.out.print("  Choose: ");
    }

    private static void YesNo()          //Βοηθητική μέθοδος για για επιβεβαίωση των επιλογών του χρήστη.
    {
        System.out.print("  ");
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        while(!option.equalsIgnoreCase("Yes") && !option.equalsIgnoreCase("y"))
        {
            if(option.equalsIgnoreCase("No") || option.equalsIgnoreCase("n")){
                Menu();
            }
            else{
                System.err.println("Wrong choice try again!!");
                option = input.nextLine();
            }
        }
    }

    private static void Empty2()                //Μέθοδος που ελέγχει αν η λίστα των παικτών είναι άδεια.
    {
        if(i == -1 && (name.isEmpty() && nickname.isEmpty() && mail.isEmpty())){
            System.out.println("\nList is empty");
            Back_Quit();
            Manage_Players();
        }
    }

    private static void Empty3()                //Μέθοδος που ελέγχει αν η λίστα των παιχνιδιών είναι άδεια.
    {
        if(j == -1 || (name_game.isEmpty() && type.isEmpty() && max_num.isEmpty() && game_date.isEmpty() && time.isEmpty() && game_place.isEmpty())){
            System.out.println("\nList is empty");
            Back_Quit();
            Manage_Games();
        }
    }
    
    private static void Empty4()                //Μέθοδος που ελέγχει αν η λίστα των παικτών είναι άδεια με διαφορετική ανακατεύθυνση από την Empty2().
    {
        if(i == -1 && (name.isEmpty() && nickname.isEmpty() && mail.isEmpty())){
            System.out.println("\nList is empty");
            Back_Quit();
            Manage_Games();
        }
    }

    private static boolean Power_Of_Two(int number)                 //Μέθοδος που ελέγχει αν ο αριθμός των παικτών είναι περιττός.
    {
        if(number <= 0){
            throw new IllegalArgumentException("number: " + number);
        }
        if((number%2)!=0){
            System.out.println("We are sorry but you have to delete a player.");
            Delete_Players();
            return false;
        }
        return false;
    }
    
    private static void Match_Pairs()               //Μέθοδος δημιουργίας ζευγαριών αντιπάλων για ένα παιχνίδι που στη συνέχεια διαγράφει τους χαμένους.
    {
        ArrayList<Integer> table = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int g=0;g<=(nickname.size()-1);g++){
            table.add(g);
        }
        Random random = new Random();
        Collections.shuffle(table, random);
        for(int g=0;g<table.size();g+=2){
            int p=1;
            int a=g+1;
            System.out.println("\n"+nickname.get(table.get(g))+"--<<VS>>--"+""+nickname.get(table.get(a)));
            do{
                System.out.print("Give the loser: ");
                String loser;
                Scanner input = new Scanner(System.in);
                loser = input.next();
                if(loser.equalsIgnoreCase(nickname.get(table.get(g)))){
                    temp.add(table.get(g));
                    p++;
                }
                else if(loser.equalsIgnoreCase(nickname.get(table.get(a)))){
                    temp.add(table.get(a));
                    p++;
                }
                else{
                    System.out.println("Nickname does not exist!!\nTry again\n");
                }
            }while(p==1);
        }
        Collections.sort(temp);
        for(int l=0;l<temp.size();l++){
            //.if(playgame.get(temp.get(l)).equals(game)){
            if(l==0){
                name.removeElementAt(temp.get(l));
                nickname.removeElementAt(temp.get(l));
                mail.removeElementAt(temp.get(l));
                playgame.removeElementAt(temp.get(l));
                i--;
            }
            if(l!=0){
                name.removeElementAt(temp.get(l-l));
                nickname.removeElementAt(temp.get(l-l));
                mail.removeElementAt(temp.get(l-l));
                playgame.removeElementAt(temp.get(l-l));
                i--;
            }
        }
    }
    
    public static boolean EmailFormatValidator(String mail){                    //Μέθοδος ελέγχου εγκυρότητας email.
	Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	Matcher matcher;    
        
	matcher = pattern.matcher(mail);
	return matcher.matches();
    }
}
