package abc;
public class HTMLComposer {

    public static String composeForConfirmed(Ticket t) {
        String status = composeInitialStatement(t);
        status += "<td>:</b> Confirmed</tr>\n<tr><td><td><b>Coach<td>:</b>" + t.CoachNo + "\n</tr>"
                + "<tr><td><b>Seat<td>:</b>" + t.SeatNo + "</tr></table>";
        return status;
    }

    public static String composeForWL(Ticket t) {
        String status = composeInitialStatement(t);
        status += "<td>:</b> Waiting List</tr>\n<tr><td><b>Waiting List No<td>:</b>" + t.SeatNo + "</tr></table>";
        return status;
    }

    public static String composeForRAC(Ticket t) {
        String status = composeInitialStatement(t);
        status += "<td>:</b> Reservation Against Cancellation</tr>\n<tr><td><b>RAC Queue No<td>:</b>" + t.SeatNo + "</tr></table>";
        return status;
    }

    private static String composeInitialStatement(Ticket t) {
        return "<b>" + t.Name + "</b><h3><pre><center>Dear Mr/Ms. Your Reservation Status</center></pre></h3>"
                + "<tr><td><b>PNR No<td>:</b>" + t.PNR + "<td><b>Ticket No<td>:</b>" + t.TicketNo + "\n</tr>"
                + "<tr><td><b>Train No<td>:</b>" + t.TrainNo + "<td><b>Date<td>:</b>" + t.DOJ + "<td><b>Status:</b>";
    }
}
