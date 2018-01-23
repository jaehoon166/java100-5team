package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Room;

public interface RoomService {
    List<Room> list(int pageNo, int pageSize, Map<String, Object> options);
    int getTotalCount();
    int add(Room room);
    int delete(int no);
}
