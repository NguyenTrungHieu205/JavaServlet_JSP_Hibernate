package repository;

import config.HibernateConfig;
import entity.ChiTietSanPham;
import entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class NhanVienRepository {
    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM NhanVien ");
            listNhanVien = (ArrayList<NhanVien>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public void addNhanVien(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateNhanVien(NhanVien nhanVien){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(nhanVien);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteNhanVien(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            NhanVien cv = session.get(NhanVien.class, id);
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

    public NhanVien getOne(String id2) {
        NhanVien nhanVien = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM NhanVien WHERE id =: id1 ",
                    NhanVien.class);
            query.setParameter("id1", id2);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }
}
