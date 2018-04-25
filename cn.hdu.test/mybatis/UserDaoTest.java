package mybatis;

import cn.hdu.mybatis.dao.UserDao;
import cn.hdu.mybatis.dao.UserDaoImpl;
import cn.hdu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    private SqlSessionFactory factory;
    @Before
    public void setUp()throws Exception{
        String resource="SqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        factory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserById()throws Exception{
        UserDao userDao=new UserDaoImpl(factory);
        User user=userDao.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void testFindUserByUsername()throws Exception{
        UserDao userDao = new UserDaoImpl(factory);
        List<User> list = userDao.findUserByUsername("王");
        System.out.println(list);
    }

}
