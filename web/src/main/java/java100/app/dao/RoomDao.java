package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Room;


public interface RoomDao {

    List<Room> findAll(Map<String, Object> params);
    int insert(Room room);
    int countAll();
    int delete(int no);
    
    
    
}
