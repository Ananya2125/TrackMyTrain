package abc;
public class Ticket {

    String PNR;
    String TrainNo;
    String DOJ;
    String TicketNo;
    String CoachNo;
    String SeatNo;
    String Name;
    int Age;
    double TicketAmount;
    String StatusCode;

    public Ticket(String PNR) {
        this.PNR = "null";
    }

    public Ticket(String PNR, String TrainNo, String DOJ, String TicketNo, String CoachNo, String SeatNo, String Name, int Age, double TicketAmount, String StatusCode) {
        this.PNR = PNR;
        this.TrainNo = TrainNo;
        this.DOJ = DOJ;
        this.TicketNo = TicketNo;
        this.CoachNo = CoachNo;
        this.SeatNo = SeatNo;
        this.Name = Name;
        this.Age = Age;
        this.TicketAmount = TicketAmount;
        this.StatusCode = StatusCode;
    }
}

