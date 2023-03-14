package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   @SuppressWarnings("unchecked")
   public void add(User user) {
     sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserById(Long id) {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User where id = " + id );
      return query.getSingleResult();
   }


   @Override
   @SuppressWarnings("unchecked")
   public User getUserByModelAndSeries(int series ,String model) {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User where car.series = " + series + " and car.model = '" + model +"'" );
      return query.getSingleResult();
   }


   @SuppressWarnings("unchecked")
   public void delete() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("delete from User");

   }

}
