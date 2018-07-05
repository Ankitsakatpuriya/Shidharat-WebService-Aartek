package com.hyringspree.repositoryImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyringspree.model.RecomendationInfo;
import com.hyringspree.repository.RecomendationRepository;

@Repository
public class RecomendationRepositoryImpl implements RecomendationRepository {
	@Autowired
	private SessionFactory factory;
	
	public RecomendationInfo editRecomendation(Integer recomendationId){
		Session session=factory.openSession();
	    Transaction transaction=session.beginTransaction();
	    RecomendationInfo recomendationInfo=session.get(RecomendationInfo.class, recomendationId);
	    session.close();
	    return recomendationInfo;
		
	}

	public boolean updateRecomendationInfo(RecomendationInfo updateRecomendationInfo) {
		if(updateRecomendationInfo.getRecomendationId()!=null){
		Session session = factory.openSession();
		session.saveOrUpdate(updateRecomendationInfo);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
		return true;
		}
		else{
		return false;	
		}
	}

}
