package com.dapeng.dao.impl;

import com.dapeng.dao.UserDao;
import com.dapeng.domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public User getByUserCode(String userCode) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", userCode));
		List<?> list = getHibernateTemplate().findByCriteria(dc);
		if(list!=null && list.size()!=0) {
			return (User)list.get(0);
		}else {
			return null;
		}
	}
	
	/*//HQL
	@Override
	public User getByUserCode(final String userCode) {
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql = "from User where user_code=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, userCode);
				User user = (User) query.uniqueResult();
				return user;
			}
			
		});
	}*/
	//我是test分支，我增加了一个文件，名字为，getComplaintListByRegistId
	
}
