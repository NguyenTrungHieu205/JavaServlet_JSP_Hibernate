package repository;

import config.HibernateConfig;
import entity.CuaHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;

public class CuaHangRepository {

    public ArrayList<CuaHang> getAll(){
        ArrayList<CuaHang> listCuaHang = new ArrayList<>();
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM CuaHang ");
            listCuaHang = (ArrayList<CuaHang>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCuaHang;
    }
    public void addCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(cuaHang);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(cuaHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean deleteCuaHang(String id){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CuaHang ch = session.get(CuaHang.class, id);
            if(ch != null){
                session.delete(ch);
            }
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public CuaHang getOne(String id2) {
        CuaHang cuaHang = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // truy van HQL
            Query query = session.createQuery("FROM CuaHang WHERE id =: id1 ",
                    CuaHang.class);
            query.setParameter("id1", id2);
            cuaHang = (CuaHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuaHang;
    }
}
