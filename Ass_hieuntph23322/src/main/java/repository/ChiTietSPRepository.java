package repository;

import config.HibernateConfig;
import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ChiTietSPRepository {

    public ArrayList<ChiTietSanPham> getAll(){
        ArrayList<ChiTietSanPham> listCTSP = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM ChiTietSanPham ");
            listCTSP = (ArrayList<ChiTietSanPham>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCTSP;
    }

    public void addCTSP(ChiTietSanPham chiTietSanPham){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateCTSP(ChiTietSanPham chiTietSanPham){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteChiTietSanPham(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ChiTietSanPham cv = session.get(ChiTietSanPham.class, id);
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

    public ChiTietSanPham getOne(String id2) {
        ChiTietSanPham chiTietSanPham = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM ChiTietSanPham WHERE id =: id1 ",
                    ChiTietSanPham.class);
            query.setParameter("id1", id2);
            chiTietSanPham = (ChiTietSanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSanPham;
    }

    public static void main(String[] args) {
        ArrayList<ChiTietSanPham> list = new ChiTietSPRepository().getAll();
        for (ChiTietSanPham s: list){
            System.out.println(s.toString());
        }
    }
}


