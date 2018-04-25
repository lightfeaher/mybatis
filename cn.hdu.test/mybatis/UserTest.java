package mybatis;

import cn.hdu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {
    @Test
    public void testFindUserById() throws Exception{
        String resource="SqlMapConfig.xml";
        //通过流将核心文件配置进来
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //通过核心文件输入流来创建会话工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂创建会话
        SqlSession openSession=factory.openSession();
        //第一个参数：所调用的sql语句=namespace+sql的ID
        User user= openSession.selectOne("test.findUserById",1);
        System.out.println(user.getId()+" "+user.getUsername()+" "+user.getSex()+
                " "+user.getBirthday()+" "+user.getAddress());
        openSession.close();
    }
    @Test
    public void testFindUserByUsername() throws Exception{
        String resource="SqlMapConfig.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession=factory.openSession();
        List<User> list = openSession.selectList("test.findUserByUsername", "王");
        System.out.println(list);
        openSession.close();
    }
    @Test
    public void testInsertUser() throws Exception{
        String resource="SqlMapConfig.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = factory.openSession();
        User user=new User();
        user.setUsername("赵四");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("北京昌平");
        openSession.insert("test.inserUser", user);
        System.out.println("=========="+user.getId());
        openSession.commit();
        openSession.close();
    }
    @Test
    public void testDelUserById() throws Exception{
        String rescource="SqlMapConfig.xml";
        InputStream inputStream=Resources.getResourceAsStream(rescource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = factory.openSession();
        openSession.delete("test.delUserById",28);
        openSession.commit();
    }
    @Test
    public void updateUserById() throws Exception{
        String resource="SqlMapConfig.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = factory.openSession();
        User user = new User();
        user.setId(26);
        user.setUsername("李妈子");
        openSession.update("test.updateUserById",user);
        openSession.commit();
    }
}
