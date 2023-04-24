package repository;

import config.HibernateConfig;
import entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
public class SanPhamRepository {
    public ArrayList<SanPham> getAll(){
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM SanPham ");
            listSanPham = (ArrayList<SanPham>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSanPham;
    }
    public void addSanPham(SanPham sanPham){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateSanPham(SanPham sanPham){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteSanPham(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            SanPham cv = session.get(SanPham.class, id);
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

    public SanPham getOne(String id2) {
        SanPham sanPham = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM SanPham WHERE id =: id1 ",
                    SanPham.class);
            query.setParameter("id1", id2);
            sanPham = (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }
}
