package backup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

//리팩토링(refactoring) : extract method
//  - 작은 기능 단위로 메소드를 추출하는 방법
 
public class App {
    static Scanner sc = new Scanner(System.in);
    
    static ArrayList<Score> list = new ArrayList<>();
    
    
    public static void main(String[] args) {
       
        loop:
        while(true) {
           System.out.println("성적관리> ");
           String input = sc.nextLine();
           
           switch (input) {
        case "add":
                doAdd(); break;
            
        case "list":
            doList(); break;
            
        case "view":
            doView(); break;
            
        case "update":
            doUpdate(); break; 
            
        case "delete":
            doDelete(); break;
            
        case "quit":
            doQuite(); break loop;
              
        default:
            doError(); break;
            
        }
           
        }
        
       
    }
    
     private static void doError() {
         System.out.println("실행할수 없는 명령어 입니다.");
        
    }

    private static void doQuite() {
         System.out.println("프로그램을 종료합니다!");
         
    }

    private static void doDelete() {
         System.out.println("[학생 삭제]");
         String name = prompt("이름? ");
         
         Score score = null;
         Iterator<Score> iterator = list.iterator();
         while(iterator.hasNext()) {
             Score temp = iterator.next();
             if(temp.name.equals(name)) {
                 score = temp;
                 break;
             }
         }
         if(score == null) {
             System.out.printf("%s 의 성적 정보가 없습니다.\n", name);
         }else {
             if(confirm2("정말 삭제 하시겠습니까?")) {
                 list.remove(score);
             }else {
                 System.out.println("삭제를 취소하였습니다.");
             }
            
         }
         
         
        
    }

    private static void doUpdate() {
         System.out.println("[학생 정보 변경]");
        String name = prompt("이름? ");
         
         Score score = null;
         Iterator<Score> iterator = list.iterator();
         while(iterator.hasNext()) {
             Score temp = iterator.next();
             if(temp.name.equals(name)) {
                 score = temp;
                 break;
             }
         }
         if(score == null) {
             System.out.printf("%s 의 성적 정보가 없습니다.\n", name);
         }else {
            
             score.update();
             
         }
        
    }

    private static void doView() {
         System.out.println("[학생 정보]");
         String name = prompt("이름? ");
         Score score = null;
        Iterator<Score> iterator;
        
         iterator = list.iterator();
         while(iterator.hasNext()) {
             Score temp = iterator.next();
             if(temp.name.equals(name)) {
                 score = temp;
                 break;
             }
         }
         if(score == null) {
             System.out.printf("%s 의 성적 정보가 없습니다.\n", name);
         }else {
             score.printDetail();
         }
        
    }

    private static void doAdd() {
         System.out.println("[학생 등록]");
         Score score;
         while(true) {
             score = new Score();
             score.input();
             list.add(score);
           
            if(!confirm("계속하시겠습니까?(Y/n)")) {
                     break;
                
                 }
         }
        
    }
     private static void doList(){
         System.out.println("[학생 목록]");
         Iterator<Score> iterator;
         iterator = list.iterator();
         while(iterator.hasNext()) {
             iterator.next().print();
         }
     }

    static String prompt(String message) {
        
        System.out.println(message);
        return sc.nextLine();
        
        
        
    }

    static boolean confirm(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String response = sc.nextLine().toLowerCase();
        
        if(response.equals("y") || response.equals("Y") || response.equals("") ) {
            return true;
        }
            return false;
        
    }
    static boolean confirm2(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String response = sc.nextLine().toLowerCase();
        
        if(response.equals("n") || response.equals("no") || response.equals("") ) {
            return false;
        }
            return true;
        
    }
}




