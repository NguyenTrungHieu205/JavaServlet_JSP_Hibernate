package repository;
import config.HibernateConfig;
import entity.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
public class MauSacRepository {
    public ArrayList<MauSac> getAll(){
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM MauSac ");
            listMauSac = (ArrayList<MauSac>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listMauSac;
    }
    public void addMauSac(MauSac mauSac){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateMauSac(MauSac mauSac){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteMauSac(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            MauSac cv = session.get(MauSac.class, id);
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

    public MauSac getOne(String id2) {
        MauSac mauSac = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM MauSac WHERE id =: id1 ",
                    MauSac.class);
            query.setParameter("id1", id2);
            mauSac = (MauSac) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }
}
