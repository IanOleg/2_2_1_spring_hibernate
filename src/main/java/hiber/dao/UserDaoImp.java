package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   public void deleteUser(int id) {
//      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id = ?");
//      query.setParameter(0, id);
//      User user = query.getSingleResult();

      sessionFactory.getCurrentSession().remove(sessionFactory.getCurrentSession().find(User.class, (long)id));
   }

   @Override
   public void deleteCar(int id) {
      sessionFactory.getCurrentSession().remove(sessionFactory.getCurrentSession().find(Car.class, (long)id));
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User>  getUserByModelAndSeries(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car.model = ? and car.series = ?");
      query.setParameter(0, model);
      query.setParameter(1, series);
      return query.getResultList();
   }

}
