package learn.biz;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import learn.entity.Job;
import learn.entity.Learnplan;
import learn.entity.Users;
import learn.util.HibernateSessionFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 单元测试
 * @author 陈双亮
 *
 */
public class Learns {
	Session session = null;
	Transaction tx = null;
	
	@Before
	public void before(){
		System.out.println("执行之前！");
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
	}
	
	@After
	public void after(){
		System.out.println("执行之后！");
		tx.commit();
		session.close();
	}
	
	@Test
	public void show01(){
		Users u = (Users) session.get(Users.class, "d351472c-8695-4205-9a5d-017ec0532591");
		System.out.println(u);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void show02(){
		String uuids[] = {"37129054-261e-4288-9e45-ff52c357c1fc","3f20bbc7-d157-4638-8f04-865c82fefa5c",
				"4b8271d7-a297-4b48-b8f9-997b80f0a763"};
		List<Users> list = session.createCriteria(Users.class)
//				.add(Restrictions.like("userPhone", "%1877%"))
//				.add(Restrictions.like("userAddress", "%36%"))
				.add(Restrictions.in("uuid", Arrays.asList(uuids)))
				.add(Restrictions.eq("age", 23))
//				.setFirstResult(2)
//				.setMaxResults(100)
				.list();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void show03(){
		/*
		 * 根据id删除
		 */
//		Users u  = new Users();
//		u.setUuid("d351472c-8695-4205-9a5d-017ec0532591");
//		session.delete(u);
		
		/*
		 * 批量删除
		 */
//		String sql = "update Users set age = ? where uuid = ?";
//		Query query = session.createQuery(sql);
//		query.setInteger(0, 23);
//		query.setString(1, "37129054-261e-4288-9e45-ff52c357c1fc");
		
		String sql = "update Users set age = :ages,sex = :sexs where userAddress like :uuids";
		Query query = session.createQuery(sql);
		query.setInteger("ages", 27);
		query.setString("sexs", "F");
		query.setString("uuids", "%38%");
		int x = query.executeUpdate();
		System.out.println("执行条数：" + x);
	}
	
	@Test
	@SuppressWarnings({ "unchecked", "unused" })
	public void show04(){
		List<Users> list = session.createCriteria(Users.class).list();
		int x = 0 ;
		for (int i = 0; i < 500 ; i++) {
			Learnplan l = new Learnplan(UUID.randomUUID().toString(), new Date(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
			session.save(l);
			x++;
		}
		System.out.println(x);
	}
	@Test
	public void show05(){
		Job b = new Job();
		b.setUuid(UUID.randomUUID().toString());
		b.setJobName("java工程师");
		b.setJobType(0);
		b.setCode(56);
		session.save(b);
	}
	
}
