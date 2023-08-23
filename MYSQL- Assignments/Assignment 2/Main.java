import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int queryNumber = Integer.parseInt(args[0]);

        switch (queryNumber) {
            case 1:
                String param = args[1];
                pro1(param);
                break;
            case 2:
                pro2();
                break;
            case 3:
                String param3 = args[1];
                int i = Integer.parseInt(param3);
                pro3(i);
                break;
            case 4:
                String param4 = args[1];
                pro4(param4);
                break;
            case 5:
                String param5 = args[1];
                pro5(param5);
                break;
            case 6:
                String param6 = args[1];
                pro6(param6);
                break;
            case 7:
                String param7 = args[1];
                pro7(param7);
                break;
            case 8:
                String param8 = args[1];
                pro8(param8);
                break;
            default:
                System.out.println("Invalid query number.");
        }


    }
    // caller to turn on connection to sql



    public static void pro1(String pro) {
        Connection connection = null;
        try {
            //
            // Connect to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/PROJECT";
            String username = "root";
            String password = "bp813562";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//'2023-03-12'

        try {
            String query = "SELECT * FROM physician P, `procedure` PR, undergoes U WHERE U.procedureID = PR.procID AND P.physicianID = U.physicianID AND PR.name ='"+pro+"'";
            // Execute query and process results
            Statement look = connection.createStatement();
            ResultSet result = look.executeQuery(query);
            while (result.next()) {
                // get all the data necessary
                String physicianName = result.getString("P.name");
                String physicianID = result.getString("physicianID");
                String snn = result.getString("ssn");
                String position = result.getString("position");
                //physicianID: 1, name: John Doe, position: Surgeon, ssn: 11111111

                System.out.println("PhysicianID: "+physicianID+", name: " + physicianName + ", position: "+position+", ssn: " + snn);
                // Print result to console

            }
            connection.close();
        }catch(SQLException e){
            System.err.println("SQL error: " + e.getMessage());


        }
        System.out.println();
        System.out.println();

    }
    public static void pro2(){

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //
            // Connect to the MySQL database
            String url = "jdbc:mysql://localhost:3306/PROJECT";
            String username = "root";
            String password = "bp813562";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String query ="Select PA.name, PH.name as physician_name, N.name as nurse_name,A.startDateTime, A.endDateTime, V2.name as primaryPhys\n" +
                    "from appointment A, patient PA, nurse N, physician PH, (select PA.primaryPhysID, PH.name\n" +
                    "                                                        from patient PA, physician PH\n" +
                    "                                                        where PA.primaryPhysID = PH.physicianID)as V2\n" +
                    "where A.patientID = PA.patientID and N.nurseID = A.nurseID and A.physicianID = PH.physicianID and V2.primaryPhysID = PA.primaryPhysID and PA.primaryPhysID != A.physicianID\n" +
                    "\n" +
                    "\n" +
                    "\n";
            // Execute query and process results
            Statement look = connection.createStatement();
            ResultSet result = look.executeQuery(query);
            StringBuilder sb = null;
            ResultSetMetaData rsmd = result.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (result.next()) {
                sb = new StringBuilder();
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = result.getString(i);
                    if (i < columnsNumber) sb.append(rsmd.getColumnLabel(i) + ":" + columnValue + ", ");
                    else sb.append(rsmd.getColumnLabel(i) + ":" + columnValue);
                }
                System.out.println();
                System.out.println();
                System.out.println(sb);
            }
            connection.close();
        }catch(SQLException e){
            System.err.println("SQL error: " + e.getMessage());


        }
        System.out.println();
        System.out.println();

    }

    public static void pro3( int cost  ){

        Connection connection = null;
        try {
            //
            // Connect to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/PROJECT";
            String username = "root";
            String password = "bp813562";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String query ="SELECT P.patientID , P.ssn, P.name, P.address, P.dob, P.phone, P.insuranceNumber , P.primaryPhysID\n" +
                    "FROM  undergoes U,  `procedure` PR join patient P\n" +
                    "WHERE U.procedureID=PR.procID AND U.patientID=P.patientID AND PR.cost >"+cost;
            // Execute query and process results
            Statement look = connection.createStatement();
            ResultSet result = look.executeQuery(query);
            StringBuilder sb = null;
            ResultSetMetaData rsmd = result.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (result.next()) {
                sb = new StringBuilder();
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = result.getString(i);
                    if (i < columnsNumber) sb.append(rsmd.getColumnLabel(i) + ":" + columnValue + ", ");
                    else sb.append(rsmd.getColumnLabel(i) + ":" + columnValue);
                }
                System.out.println();
                System.out.println();
                System.out.println(sb);
            }
            connection.close();
        }catch(SQLException e){
            System.err.println("SQL error: " + e.getMessage());


        }
        System.out.println();
        System.out.println();

    }

    public static void pro4(  String arg ){

        Connection connection = null;
        try {
            //
            // Connect to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/PROJECT";
            String username = "root";
            String password = "bp813562";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String query ="SELECT  P.patientID ,P.ssn, P.name, P.address, P.dob, P.phone, P.insuranceNumber, P.primaryPhysID\n" +
                    "FROM department D join patient P\n" +
                    "Where D.headID=P.primaryPhysID AND D.name ='"+arg+"'";
            // Execute query and process results
            Statement look = connection.createStatement();
            ResultSet result = look.executeQuery(query);
            StringBuilder sb = null;
            ResultSetMetaData rsmd = result.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (result.next()) {
                sb = new StringBuilder();
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = result.getString(i);
                    if (i < columnsNumber) sb.append(rsmd.getColumnLabel(i) + ":" + columnValue + ", ");
                    else sb.append(rsmd.getColumnLabel(i) + ":" + columnValue);
                }
                System.out.println();
                System.out.println();
                System.out.println(sb);
            }
            connection.close();
        }catch(SQLException e){
            System.err.println("SQL error: " + e.getMessage());


        }
        System.out.println();
        System.out.println();

    }

    public static void pro5(  String arg ){

        Connection connection = null;
        try {
            //
            // Connect to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/PROJECT";
            String username = "root";
            String password = "bp813562";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String query ="SELECT PT.name as patient_name , PH.name as Physician_name , P.prescribedDate\n" +
                    "FROM prescribes P, patient PT, physician PH, medication M\n" +
                    "WHERE P.physicianID=PH.physicianID AND P.patientID=PT.patientID  and P.medicationID= M.medID and M.name='"+arg+"'";
            // Execute query and process results
            Statement look = connection.createStatement();
            ResultSet result = look.executeQuery(query);
            StringBuilder sb = null;
            ResultSetMetaData rsmd = result.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (result.next()) {
                sb = new StringBuilder();
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = result.getString(i);
                    if (i < columnsNumber) sb.append(rsmd.getColumnLabel(i) + ":" + columnValue + ", ");
                    else sb.append(rsmd.getColumnLabel(i) + ":" + columnValue);
                }
                System.out.println();
                System.out.println();
                System.out.println(sb);
            }
            connection.close();
        }catch(SQLException e){
            System.err.println("SQL error: " + e.getMessage());


        }
        System.out.println();
        System.out.println();
    }


    public static void pro6(  String arg ){

        Connection connection = null;
        try {
            //
            // Connect to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/PROJECT";
            String username = "root";
            String password = "bp813562";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String query ="SELECT N.nurseID, N.name, N.position, N.ssn, OC.startDate,OC.endDate\n" +
                    "FROM nurse N , onCall OC\n" +
                    "WHERE N.nurseID=OC.nurseID AND OC.startDate='"+arg+"'";
            // Execute query and process results
            Statement look = connection.createStatement();
            ResultSet result = look.executeQuery(query);
            StringBuilder sb = null;
            ResultSetMetaData rsmd = result.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (result.next()) {
                sb = new StringBuilder();
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = result.getString(i);
                    if (i < columnsNumber) sb.append(rsmd.getColumnLabel(i) + ":" + columnValue + ", ");
                    else sb.append(rsmd.getColumnLabel(i) + ":" + columnValue);
                }
                System.out.println();
                System.out.println();
                System.out.println(sb);
            }
            connection.close();
        }catch(SQLException e){
            System.err.println("SQL error: " + e.getMessage());


        }
        System.out.println();
        System.out.println();

    }

    public static void pro7(  String arg ){

        Connection connection = null;
        try {
            //
            // Connect to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/PROJECT";
            String username = "root";
            String password = "bp813562";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String query ="select P.name as patientName,S.startDate,S.endDate\n" +
                    "from patient P,stay S ,room R \n" +
                    "where P.patientID=S.patientID and R.roomID=S.roomID and R.roomType='Double' AND date('"+arg+"') Between S.startDate and S.endDate;\n";

            // Execute query and process results
            Statement look = connection.createStatement();
            ResultSet result = look.executeQuery(query);
            StringBuilder sb = null;
            ResultSetMetaData rsmd = result.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (result.next()) {
                sb = new StringBuilder();
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = result.getString(i);
                    if (i < columnsNumber) sb.append(rsmd.getColumnLabel(i) + ":" + columnValue + ", ");
                    else sb.append(rsmd.getColumnLabel(i) + ":" + columnValue);
                }
                System.out.println();
                System.out.println();
                System.out.println(sb);
            }
            connection.close();
        }catch(SQLException e){
            System.err.println("SQL error: " + e.getMessage());


        }
        System.out.println();
        System.out.println();

    }

    public static void pro8(  String arg ){

        Connection connection = null;
        try {
            //
            // Connect to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/PROJECT";
            String username = "root";
            String password = "bp813562";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String query ="SELECT P.patientID, P.ssn, P.name as PatientName, P.dob, P.phone, P.insuranceNumber, P.primaryPhysID, PH.physicianID, PH.name as physicianName, PH.position, PH.ssn, A.appID\n" +
                    "FROM  appointment A, physician PH, department D, patient P\n" +
                    "WHERE P.primaryPhysID=PH.physicianID AND A.physicianID=PH.physicianID AND A.patientID=P.patientID AND D.headID=PH.physicianID AND D.name='"+arg+"'";
            // Execute query and process results
            Statement look = connection.createStatement();
            ResultSet result = look.executeQuery(query);
            StringBuilder sb = null;
            ResultSetMetaData rsmd = result.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (result.next()) {
                sb = new StringBuilder();
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = result.getString(i);
                    if (i < columnsNumber) sb.append(rsmd.getColumnLabel(i) + ":" + columnValue + ", ");
                    else sb.append(rsmd.getColumnLabel(i) + ":" + columnValue);
                }
                System.out.println();
                System.out.println();
                System.out.println(sb);
            }
            connection.close();
        }catch(SQLException e){
            System.err.println("SQL error: " + e.getMessage());


        }
        System.out.println();
        System.out.println();
    }


}
