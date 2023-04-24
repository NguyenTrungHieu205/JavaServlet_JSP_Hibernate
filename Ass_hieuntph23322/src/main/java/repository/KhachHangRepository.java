package repository;

import config.HibernateConfig;
//import org.hibernate.query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import entity.KhachHang;

import java.util.ArrayList;

public class KhachHangRepository {

    public ArrayList<KhachHang> getAll(){
        ArrayList<KhachHang> listKachHang = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM KhachHang ");
            listKachHang = (ArrayList<KhachHang>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listKachHang;
    }

    public void addKhachHang(KhachHang khachHang){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateKhachHang(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteKhachHang(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            KhachHang kh = session.get(KhachHang.class, id);
            if(kh != null){
                session.delete(kh);
            }
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public KhachHang getOne(String id2) {
        KhachHang khachHang = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM KhachHang WHERE id =: id1 ",
                    KhachHang.class);
            query.setParameter("id1", id2);
            khachHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public static void main(String[] args) {
        ArrayList<KhachHang> list = new KhachHangRepository().getAll();
        for (KhachHang kh : list){
            System.out.println(kh.toString());
        }

    }
}
