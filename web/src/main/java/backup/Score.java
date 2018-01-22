package backup;
import java.util.Scanner;

//: ## 생성자와 인스턴스 메서드 도입
//: - init() 메서드 대신 생성자를 이용하여 인스턴스를 초기화시킨다.
//: - print() 메서드는 인스턴스 데이터를 다루기 때문에 스태틱 메서드 대신
//:   인스턴스 메서드로 전환한다. 
//: 캡슐화 문법을 적용하라!
//: setter / getter의 정의와 사용을 연습한다!

public class Score {
    
    protected String name;
    protected int[] subjects; 
    protected int sum;
    protected float aver;

    
    //: ### 생성자 
    // public으로 공개한다. 다른 패키지에서도 호출할수 있도록 변경!
    public Score(){
        this.subjects = new int[3];
    }
    
    
    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.subjects = new int[]{kor, eng, math};
        
        this.compute();
    }
    
     
    
    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다.
    
    // 내부에서만 사용할 메서드이기 때문에 공개하지 않는다.
    private void compute() {
        this.sum=0;
        
        for (int sub : this.subjects) {
            this.sum += sub;
        }
        
        this.aver = (float)this.sum / this.subjects.length;
    }
    
    //전체공개할 메서드는 public으로 공개한다.
    public void print() {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                this.name, 
                this.subjects[0], 
                this.subjects[1], 
                this.subjects[2], 
                this.sum, 
                this.aver);
    }
    public void printDetail() {
        
            System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",   
                    this.name, 
                    this.subjects[0], 
                    this.subjects[1], 
                    this.subjects[2], 
                    this.sum, 
                    this.aver);
        
        
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
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름?");
        this.name = sc.nextLine();
        
        System.out.println("국어?");
        this.subjects[0] = sc.nextInt();
        System.out.println("영어?");
        this.subjects[1] = sc.nextInt();
        System.out.println("수학?");
        this.subjects[2] = sc.nextInt();
        
        this.compute();
        
    }
    public void update() {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("국어? (%d) ",this.subjects[0]);
        int kor = this.subjects[0];
        try {
            kor = Integer.parseInt(sc.nextLine()); 
        }catch (Exception e) {
        }
        
        System.out.printf("영어? (%d) ",this.subjects[1]);
        int eng = this.subjects[1];
        try {
            eng = Integer.parseInt(sc.nextLine()); 
        }catch (Exception e) {
        }
        System.out.printf("수학? (%d) ",this.subjects[2]);
        int math = this.subjects[2];
        try {
            math = Integer.parseInt(sc.nextLine()); 
        }catch (Exception e) {
        }
        
        if(confirm2("변경 하시겠습니까?(y/N) ")) {
            this.subjects[0] = kor;
            this.subjects[1] = eng;
            this.subjects[2] = math;
            this.compute();
            System.out.println("변경 하였습니다!");
            
        }else{
            System.out.println("변경을 취소하였습니다.");
        }
        
        
    }
}
