package learn.biz;

import java.util.ArrayList;

import learn.entity.Learnplan;
import learn.entity.Users;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@SuppressWarnings({ "unchecked", "unused" })
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class LearnGis extends AbstractTestNGSpringContextTests {
	@Autowired
	private HibernateTemplate ht;

	private Logger log = Logger.getLogger(LearnGis.class);

	/*
	 * 查询
	 */
	@Test
	public void query() {
		Learnplan u = null;
		Users us = new Users();
		ArrayList<Users> list = null;
		// 根据序列号查询
		u = ht.get(Learnplan.class, "e99f0ced-edbf-490f-a433-f4f020c45707");
		// System.out.println(u);
		u = ht.load(Learnplan.class, "e9b8b274-7f8e-4c86-b329-e8a566a37fb4");
		// System.out.println(u);

		// 条件查询
		String hql = "from Users where Useraddress like ? and userName like ?";
		list = (ArrayList<Users>) ht.find(hql, "%361%", "%n2%");
		// System.out.println(list.get(0));

		hql = "from Users where Useraddress like :a";
		list = (ArrayList<Users>) ht.findByNamedParam(hql, "a", "%36%");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// System.out.println(list.get(0));

		hql = "from Users where Useraddress like :a and userName like :b";
		list = (ArrayList<Users>) ht.findByNamedParam(hql, new String[] { "a",
				"b" }, new Object[] { "%361%", "%n2%" });
		// System.out.println(list.get(0));

		hql = "from Users where Useraddress like :userAddress and userName like :userName";
		us.setUserName("%n2%");
		us.setUserAddress("%361%");
		;
		list = (ArrayList<Users>) ht.findByValueBean(hql, us);
		// System.out.println(list.get(0));

		// 分页
		list = (ArrayList<Users>) ht.findByExample(us, 1, 3);

		list = ht.execute(new HibernateCallback<ArrayList<Users>>() {

			@Override
			public ArrayList<Users> doInHibernate(Session session)
					throws HibernateException {
				return (ArrayList<Users>) session.createCriteria(Users.class)
						.add(Restrictions.like("userAddress", "%36%"))
						.setFirstResult(1).setMaxResults(3).list();
			}
		});
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	/*
	 * 更新
	 */
	@Test
	// @Transactional(readOnly=true, propagation = Propagation.REQUIRED)
	public void updateTest() {
		Learnplan u = new Learnplan();
		int x = ht.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException {
				try {
					Learnplan u = new Learnplan();
					u.setUuid("e9b8b274-7f8e-4c86-b329-e8a566a37fb4");
					u.setPlanner("陈双亮");
					u.setContents("没有计划！");
					session.saveOrUpdate(u);
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}
		});
		System.out.println(x);
		u.setUuid("e9b8b274-7f8e-4c86-b329-e8a566a37fb4");
		ht.delete(u);
		u = ht.get(Learnplan.class, "e9b8b274-7f8e-4c86-b329-e8a566a37fb4");
		System.out.println(u);
	}

	@Test
	public void show04() {
		Users u = new Users();
		u.setAge(23);
		int x = ht.findByExample(u, 3, 10).size();
		log.info(x);
		log.trace("我是log，trace");
		log.debug("我是log，debug");
		log.info("我是log，info");
		log.warn("我是log，warn");
		log.error("我是log，error");
		log.fatal("我是log，fatal");

	}
}
