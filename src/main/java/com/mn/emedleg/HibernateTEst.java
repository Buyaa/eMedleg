package com.mn.emedleg;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mn.emedleg.entity.CUser;
import com.mn.emedleg.entity.cms.CComment;
import com.mn.emedleg.entity.cms.CMCategory;
import com.mn.emedleg.entity.cms.CMenu;
import com.mn.emedleg.entity.cms.CPublication;
import com.mn.emedleg.entity.cms.IContent;
import com.mn.emedleg.entity.cms.IItem;
import com.mn.emedleg.entity.cms.IMenu;

public class HibernateTEst {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			CUser buyaa = new CUser("Buyaa");
			IMenu product = new CMCategory("Product", buyaa);
			
			IMenu medee = new CMenu(null, "News", new CUser("Bayaraa"));
			
			IMenu laptop = new CMenu(product, "Apple", new CUser("Bayaraa"));
			IContent pub1 = new CPublication(buyaa,
					"The iPhone 5S and iPhone 5C have been announced. So what does that mean for the iPhone 6?\n"
							+ "One thing is for sure, with potential refreshes of such super handsets as the Samsung Galaxy S4, Sony Xperia Z and HTC One, the next iPhone will have to seriously up its game.",
					"New Iphoen 6 is coming", medee);

			IContent pub2 = new CPublication(buyaa,
					"The iPhone 5S and iPhone 5C have been announced. So what does that mean for the iPhone 6?\n"
							+ "Well, we'll tell you. Or, at least, we'll tell you what we can glean from rumor and speculation - some reliable, some not so much.\n"
							+ "iOS 7: Apple's new look for iPhone and iPad\n"
							+ "Given the iPhone's history - from the 3G onwards, there's always been a half-step S model before the next numbered iPhone - so it was no surprise the 5S was first and so we're looking at 2014 for a new iPhone 6.\n"
							+ "One thing is for sure, with potential refreshes of such super handsets as the Samsung Galaxy S4, Sony Xperia Z and HTC One, the next iPhone will have to seriously up its game.",
					"New IPhone 6 is released", medee);
			IContent macbook = new CPublication(buyaa,
					"Whatever the task, fourth-generation Intel Core processors with Intel HD Graphics 5000 are up to it. From editing photos to perfecting a presentation to just browsing the web, "
							+ "everything moves ultrafast. These new processors also help give MacBook Air its extended battery life, thanks to a new architecture that’s designed to use less power.",
					"Macbook air zarna", laptop);
			IItem maccomm1 = new CComment(macbook, "bat", "Hed yum be");
			IItem maccomm2 = new CComment(macbook, "buyaa", "1500$");
			session.persist(product);
			session.persist(medee);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<IMenu> menus = session.createQuery("from AMenu").list();
			for (IMenu content : menus) {
				System.out.println("******************************************************");
				System.out.println("Title: " + content.getTitle() + " User: "+ content.getUserName());
				for (IContent cont : content.getContents()) {
					System.out.println("------------------------------------------------------");
					System.out.println("Title: " + cont.getTitle() + " User: "+ cont.getUserName());
					System.out.println("Content: " + cont.getContent());
					System.out.println("------Comments:------------------------------------------------");
					for (IItem comment : cont.getComments())
						System.out.println("User: "	+ comment.getUserName() + " Commnet: "	+ comment.getTitle());
					System.out.println("------------------------------------------------------");
				}

				System.out.println("******************************************************");
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
