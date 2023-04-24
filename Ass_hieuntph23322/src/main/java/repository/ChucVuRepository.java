package repository;

import config.HibernateConfig;
import entity.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import entity.ChucVu;


import java.util.ArrayList;

public class ChucVuRepository {


    public ArrayList<ChucVu> getAll(){
        ArrayList<ChucVu> listChucVu = new ArrayList<>();
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM ChucVu ");
             listChucVu = (ArrayList<ChucVu>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listChucVu;
    }
    public void addChucVu(ChucVu chucVu){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chucVu);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateChucVu(ChucVu chucVu){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(chucVu);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteChucVu(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ChucVu cv = session.get(ChucVu.class, id);
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

    public ChucVu getOne(String id2) {
        ChucVu chucVu = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM ChucVu WHERE id =: id1 ",
                    ChucVu.class);
            query.setParameter("id1", id2);
            chucVu = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }

    public static void main(String[] args) {
        ArrayList<ChucVu> list = new ChucVuRepository().getAll();
        for (ChucVu kh : list){
            System.out.println(kh.toString());
        }

    }
}
