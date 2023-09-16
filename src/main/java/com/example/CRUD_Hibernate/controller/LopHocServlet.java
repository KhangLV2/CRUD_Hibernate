package com.example.CRUD_Hibernate.controller;

import com.example.CRUD_Hibernate.entity.LopHoc;
import com.example.CRUD_Hibernate.repository.LopHocRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LopHocServlet", value = {
        "/load",
        "/view-add",
        "/add",
        "/view-update",
        "/update",
        "/delete"
})
public class LopHocServlet extends HttpServlet {

    private LopHocRepository lopHocRepository;

    public LopHocServlet() {
        this.lopHocRepository = new LopHocRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String uri = request.getRequestURI();
         if (uri.contains("load")){
             this.danhSachLopHoc(request,response);
         }else if (uri.contains("view-add")){
             this.viewAddLopHoc(request,response);
         }else if (uri.contains("view-update")){
             this.viewUpdateLopHoc(request,response);
         }else if (uri.contains("delete")){
             this.deleteLopHoc(request,response);
         }else {
             this.danhSachLopHoc(request,response);
         }
    }

    private void deleteLopHoc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        LopHoc lopHoc = this.lopHocRepository.findById(id);
        this.lopHocRepository.delete(lopHoc);
        response.sendRedirect("load");
    }

    private void viewUpdateLopHoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("idLopHoc"));
        LopHoc lopHoc = this.lopHocRepository.findById(id);

        request.setAttribute("lh",lopHoc);

        request.getRequestDispatcher("/view/update-lop-hoc.jsp").forward(request,response);
    }

    private void viewAddLopHoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-lop-hoc.jsp").forward(request,response);
    }

    private void danhSachLopHoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LopHoc> listLopHoc = this.lopHocRepository.finAll();

        request.setAttribute("lopHoc",listLopHoc);

        request.getRequestDispatcher("/view/list-lop-hoc.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String uri = request.getRequestURI();
           if (uri.contains("add")){
               this.addLopHoc(request,response);
           }else {
               this.updateLopHoc(request,response);
           }
    }

    private void addLopHoc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        Integer soLuong = Integer.valueOf(request.getParameter("soluong"));
        String toa = request.getParameter("toa");

        LopHoc lopHoc = new LopHoc(ma,ten,soLuong,toa);
        this.lopHocRepository.add(lopHoc);

        response.sendRedirect("load");

    }

    private void updateLopHoc(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Cách 1:
//        Long id = Long.valueOf(request.getParameter("id"));
//        LopHoc lopHoc = this.lopHocRepository.findById(id);
//        lopHoc.setMaLop(request.getParameter("ma"));
//        lopHoc.setTenLop(request.getParameter("ten"));
//        lopHoc.setSoLuong(Integer.valueOf(request.getParameter("soluong")));
//        lopHoc.setToa(request.getParameter("toa"));


        //Cách 2:
        Long id = Long.valueOf(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        Integer soLuong = Integer.valueOf(request.getParameter("soluong"));
        String toa = request.getParameter("toa");

        LopHoc lopHoc = new LopHoc(id,ma,ten,soLuong,toa);

        this.lopHocRepository.update(lopHoc);
        response.sendRedirect("load");
    }

}
