import com.gusi.demo.seckill.dao.KilledResultDao;
import com.gusi.demo.seckill.dao.SeckillDao;
import com.gusi.demo.seckill.pojo.KilledResult;
import com.gusi.demo.seckill.pojo.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by GUSI on 2017/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml"})
public class DaoTest {
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private KilledResultDao killedResultDao;

    @Test
    public void testEV() {
        System.out.println(seckillDao);
        System.out.println(killedResultDao);
    }

    @Test
    public void test101() {
        Seckill seckill = seckillDao.queryById(1001);
        System.out.println(seckill);
    }

    @Test
    public void test102() {
        List<Seckill> seckills = seckillDao.queryAll(0, 10);
        System.out.println(seckills);
    }

    @Test
    public void test103() {
        int result = seckillDao.redurceNumber(1001, new Date(System.currentTimeMillis()));
        System.out.println(result);
    }

    @Test
    public void test201() {
        int result = killedResultDao.insertKilled(1001, "13554133412");
        System.out.println(result);
    }

    @Test
    public void test202() {
        KilledResult result = killedResultDao.queryByIdWithSeckill(1001);
        System.out.println(result);
    }

}
