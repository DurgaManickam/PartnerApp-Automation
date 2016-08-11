package com.driveu.partnerapp;

import java.sql.*;

public class SeleniumDatabase {

   private Connection connection;
   private static Statement statement;
   PreparedStatement preparedStatement;
   private static ResultSet rs;
   String BookingId;

    
    public void setUp() {
            String databaseURL = "jdbc:mysql://176.9.18.111:3306/driveu";
            String user = "driveu";
            String password = "driveu123@";
            connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to Database...");
                connection = DriverManager.getConnection(databaseURL, user, password);
                if (connection != null) {
                    System.out.println("Connected to the Database...");
                }
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
            catch (ClassNotFoundException ex) {
               ex.printStackTrace();
            }
    }

 
    public String getAppBookingDataBase() {
        try {
            String query = "select booking_id,status from app_booking where customer_mobile=9787544561 and status=0";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                BookingId= rs.getString("booking_id");
                System.out.println(BookingId); 
          
            	String queryone = "update app_booking set status=1 where booking_id="+"\""+BookingId+"\"";
            	System.out.print(queryone);
            	statement.executeUpdate(queryone);
         
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
		return BookingId;
    }
    
    String booking(String booking){
    	booking = BookingId;
    	return booking;
    }

  
    public void tearDown() {
      if (connection != null) {
                try {
                    System.out.println("Closing Database Connection...");
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
      }
}