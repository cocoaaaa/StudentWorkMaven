package unp.student.work.manager.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.WorkLatePersonDao;
import unp.student.work.manager.domain.late_person;

@Repository("latepersonDao")
public class WorkLatePersonDaoImpl extends BaseDaoImpl<late_person> implements WorkLatePersonDao {

	public List findPageByStudent(String studentid,int pageno) {
		// TODO Auto-generated method stub
		String hql="from late_person lp where lp.personInfo.studentid=:studentid";
		return getSession().createQuery(hql).setString("studentid", studentid)
				.setFirstResult((pageno-1)*10).setMaxResults(10).list()
				;
	}

	public List findPageByManager(String studentid,int pageno) {
		// TODO Auto-generated method stub
		String hql="from late_person lp  where lp.late_info.personInfo.studentid=:studentid and lp.status=0";
		return getSession().createQuery(hql).setString("studentid", studentid)
				.setFirstResult((pageno-1)*10).setMaxResults(10).list();
	}

	public List findPageByLateInfo(int lateinfoid,int pageno) {
		// TODO Auto-generated method stub
		String hql="from late_person lp where lp.late_info.id=:lateinfoid and lp.status!=1";
		return getSession().createQuery(hql).setInteger("lateinfoid", lateinfoid)
				.setFirstResult((pageno-1)*10).setMaxResults(10).list();
	}

	public long findCountByStudent(String studentid) {
		// TODO Auto-generated method stub
				String hql="select count(*) from late_person lp where lp.personInfo.studentid=:studentid";
				return (Long)getSession().createQuery(hql).setString("studentid", studentid)
						.uniqueResult()
						;
	}

	public long findCountByManager(String studentid) {
		// TODO Auto-generated method stub
		String hql=" select count(*) from late_person lp  where lp.late_info.personInfo.studentid=:studentid and lp.status=0";
		return (Long)getSession().createQuery(hql).setString("studentid", studentid)
				.uniqueResult();
	}

	public long findCountByLateInfo(int lateinfoid) {
		// TODO Auto-generated method stub
		String hql="select count(*) from late_person lp where lp.late_info.id=:lateinfoid and lp.status!=1";
		return (Long)getSession().createQuery(hql).setInteger("lateinfoid", lateinfoid)
				.uniqueResult();
	}

	

}
