package repository;

import config.HibernateConfig;
import entity.MauSac;
import entity.NSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class NSXRepository {
    public ArrayList<NSX> getAll(){
        ArrayList<NSX> listNSX = new ArrayList<>();
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM NSX ");
            listNSX = (ArrayList<NSX>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNSX;
    }
    public void addNSX(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateNSX(NSX nsx){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteNSX(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            NSX cv = session.get(NSX.class, id);
            if(cv != null){
                session.delete(cv);
            }
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public NSX getOne(String id2) {
        NSX nsx = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM NSX WHERE id =: id1 ",
                    MauSac.class);
            query.setParameter("id1", id2);
            nsx = (NSX) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }
}
