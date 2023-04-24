package repository;

import config.HibernateConfig;
import entity.DongSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class DongSPRepository {
    public ArrayList<DongSanPham> getAll(){
        ArrayList<DongSanPham> listDongSP = new ArrayList<>();
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM DongSanPham ");
            listDongSP = (ArrayList<DongSanPham>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listDongSP;
    }
    public void addDongSanPham(DongSanPham dongSP){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateDongSanPham(DongSanPham dongSP){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteDongSanPham(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            DongSanPham cv = session.get(DongSanPham.class, id);
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

    public DongSanPham getOne(String id2) {
        DongSanPham dongSP = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM DongSanPham WHERE id =: id1 ",
                    DongSanPham.class);
            query.setParameter("id1", id2);
            dongSP = (DongSanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }
}
