package com.product_tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class exportProductList {


    @Autowired
    myApplicationBean myApplicationBean;

    public void exportproductstofileonlyblack_txt() {
        LocalDate currentDate = LocalDate.now();

        String query = "SELECT " +
                "'id', 'comments','description', 'location','owner', 'product Code','serial number','demo', 'reserved by' " +
                "UNION " +
                "SELECT * FROM product_tracking.product WHERE owner = 'black' ";


        try (Connection connection = DriverManager.getConnection(
                myApplicationBean.getAppURL(),
                myApplicationBean.getAppUser(),
                myApplicationBean.getAppPassword());

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            List<String> resultData = new ArrayList<>();

            while (resultSet.next()) {
                StringBuilder row = new StringBuilder();
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    row.append(resultSet.getString(i));
                    if (i <= columnCount) {
                        row.append(';');
                    }
                }
                resultData.add(row.toString());
            }
            Path filepath = Paths.get(myApplicationBean.getSavePath(), "ProductListExport_black_" + currentDate + ".txt");
            Files.write(filepath, resultData);

            Path csvfilepath = Paths.get(myApplicationBean.getSavePath(), "ProductListExport_black_" + currentDate + ".csv");
            Files.write(csvfilepath, resultData);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void exportproductstofile_txt() {
        LocalDate currentDate = LocalDate.now();

        String query = "SELECT " +
                "'id', 'comments','description', 'location','owner', 'product Code','serial number','demo','reserved by' " +
                "UNION " +
                "SELECT * FROM product_tracking.product ";


        try (Connection connection = DriverManager.getConnection(
                myApplicationBean.getAppURL(),
                myApplicationBean.getAppUser(),
                myApplicationBean.getAppPassword());

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            List<String> resultData = new ArrayList<>();

            while (resultSet.next()) {
                StringBuilder row = new StringBuilder();
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    row.append(resultSet.getString(i));
                    if (i <= columnCount) {
                        row.append(';');
                    }
                }
                resultData.add(row.toString());
            }
            Path filepath = Paths.get(myApplicationBean.getSavePath(), "ProductListExport_" + currentDate + ".txt");
            Files.write(filepath, resultData);

            Path csvfilepath = Paths.get(myApplicationBean.getSavePath(), "ProductListExport_" + currentDate + ".csv");
            Files.write(csvfilepath, resultData);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void exportproductstofileonly3dparty_txt() {
        LocalDate currentDate = LocalDate.now();

        String query = "SELECT " +
                "'id', 'comments','description', 'location','owner', 'product Code','serial number','demo', 'reserved by' " +
                "UNION " +
                "SELECT * FROM product_tracking.product WHERE owner = '3D_party' ";


        try (Connection connection = DriverManager.getConnection(
                myApplicationBean.getAppURL(),
                myApplicationBean.getAppUser(),
                myApplicationBean.getAppPassword());

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            List<String> resultData = new ArrayList<>();

            while (resultSet.next()) {
                StringBuilder row = new StringBuilder();
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    row.append(resultSet.getString(i));
                    if (i <= columnCount) {
                        row.append(';');
                    }
                }
                resultData.add(row.toString());
            }
            Path filepath = Paths.get(myApplicationBean.getSavePath(), "ProductListExport_3Dparty_" + currentDate + ".txt");
            Files.write(filepath, resultData);

            Path csvfilepath = Paths.get(myApplicationBean.getSavePath(), "ProductListExport_3Dparty_" + currentDate + ".csv");
            Files.write(csvfilepath, resultData);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
