package mybatis;

import cn.hdu.mybatis.Mapper.UserMapper;
import cn.hdu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    private SqlSessionFactory factory;
    @Before
    public void setUp()throws Exception{
        String resource="SqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserById()throws Exception{
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);

    }
    @Test
    public void testFindUserByUsername()throws Exception{
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        List<User> list = mapper.findUserByUsername("王");
        System.out.println(list);
    }
}
