package Board.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minkyoungsoo on 2016. 7. 28..
 */
public class UserDao {
    
    private static List<UserDto> userDtoList = new ArrayList<UserDto>();
    private static UserDao userDao = null;
    
    private UserDao() {
    }
    
    public static UserDao getInstance() {
        if(userDao == null) {
            
            userDao = new UserDao();

            UserDto userDto = new UserDto();
            userDto.setId("test");
            userDto.setPassword("1111");

            userDao.userDtoList.add(userDto);
        }
        
        return userDao;
    }
    
    public UserDto getUser(String id) {
        for(UserDto userDto : userDtoList) {
            if(id.equals(userDto.getId()))
                return userDto;
        }
        
        return null;
    }
    
    public boolean userInsert(UserDto userDto) {
        userDtoList.add(userDto);
        
        return true;
    }
    
    public boolean modifyUser(UserDto userDto) {
        
        return true;
    }
    
    public boolean deleteUser(String id) {
        for(UserDto userDto : userDtoList) {
            if(id.equals(userDto.getId()))
                userDtoList.remove(userDto);
        }
        
        return true;
    }
}
