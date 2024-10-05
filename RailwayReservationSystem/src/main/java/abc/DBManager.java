package abc;
import java.sql.*;

public class DBManager {
	public static Ticket getTicketInfo(String pnr) {
        String trainNo = "";
        Ticket t = null;

        try (Connection con = DriverManager.getConnection("jdbc:odbc:reservation", "", "");
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Ticket WHERE PNR = ?")) {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            ps.setString(1, pnr);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    trainNo = rs.getString(2);
                    java.util.Date date = rs.getDate(3);
                    String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);

                    t = new Ticket(pnr, trainNo, formattedDate, rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getString(7),
                            rs.getInt(8), rs.getDouble(9), rs.getString(10));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return t;
    }
}
