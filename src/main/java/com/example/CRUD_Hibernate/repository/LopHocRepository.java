package com.example.CRUD_Hibernate.repository;

import com.example.CRUD_Hibernate.entity.LopHoc;
import com.example.CRUD_Hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class LopHocRepository {

    public ArrayList<LopHoc> finAll(){
        ArrayList<LopHoc> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from LopHoc");
            list = (ArrayList<LopHoc>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public LopHoc findById(Long id){
        LopHoc lopHoc = new LopHoc();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            //Cách 1:

//            Query query = session.createQuery("from LopHoc where id=:idLopHoc");
//            query.setParameter("idLopHoc",id);
//            lopHoc = (LopHoc) query.getSingleResult();

            //Cách 2:
            lopHoc = session.get(LopHoc.class,id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return lopHoc;
    }

    public void add(LopHoc lopHoc){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(lopHoc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(LopHoc lopHoc){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(lopHoc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(LopHoc lopHoc){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.remove(lopHoc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        new LopHocRepository().finAll().forEach(e -> System.out.println(e.toString()));
        LopHocRepository lopHocRepository = new LopHocRepository();
        LopHoc lopHoc = lopHocRepository.findById(2L);
        System.out.println(lopHoc);
    }
}
