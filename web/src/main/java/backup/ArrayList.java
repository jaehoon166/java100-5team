package backup;

public class ArrayList<T> {

    private Object[] list = new Object[100];
    private int cursor = 0;
    
    
    //파라미터로 모든 타입의 객체 주소를 받을 수 있게 전환한다.
    void add(T obj) {
        if(this.cursor == this.list.length) {
            
            System.out.println("저장개수 초과");
            return;
        }
        this.list[this.cursor++] = obj;
    }
    
    int size() {
        return this.cursor;
    }
    
    
    @SuppressWarnings("unchecked")
    T get(int index) {
        if(index < 0 || index >= this.cursor) {
            return null;
        }
        return (T)this.list[index];
    }
    
}
