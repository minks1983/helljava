package Board.Model;

import java.util.Date;

/**
 * Created by minkyoungsoo on 2016. 7. 28..
 */
public class UserDto {
    private String id;
    private String password;
    private Date regDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
