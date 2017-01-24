import com.mwb.data.dao.filter.UserFilter;
import com.mwb.data.dao.mapper.UserMapper;
import com.mwb.data.dao.module.User;
import com.mwb.data.dao.module.UserStatus;
import com.mwb.web.framework.model.Bool;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MapperTest extends AbstractPersistenceTest {

    @Autowired
    UserMapper mapper;

//    @Test
    public void getUser() {
        User user = mapper.selectUser(1);
        System.out.println(user);

        UserFilter filter = new UserFilter();
//        filter.setName("mwb");
//        filter.setMobile("7767");
        filter.setMarital(Bool.N);
        filter.setStatus(UserStatus.ACTIVE);
        filter.setContainsScores(Arrays.asList(1));

        List<User> list = mapper.selectUserByFilter(filter);

        System.out.println(list.size());
    }
//    @Test
    public void createUser() {
        User user = mapper.selectUser(1);
        user.setId(null);
        user.setCreateTime(new Date());

        mapper.insertUser(user);

    }

    @Test
    public void updateUser() {
        User user = mapper.selectUser(4);
        user.setId(2);
        user.setCreateTime(new Date());

        mapper.updateUser(user);

    }
}