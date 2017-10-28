import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Gayathri on 10/28/2017.
 */
public class MainClass {

    public static void main(String[] args) throws ParseException {
        //studentComparison();
        auditLogsComparison();
    }

    private static void studentComparison(){
        Student student1 = new Student("Gayathri", 26);
        Student student2 = new Student("Kalani", 24);
        Student student3 = new Student("Amal", 40);
        Student student4 = new Student("Mahesh", 10);
        Student student5 = new Student("Jhon", 26);

        List<Student> list = new ArrayList<Student>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);

        // Sort by  name
        Collections.sort(list);
        System.out.println("Sort by Natural order");
        for (Student l: list){
            System.out.println(l.getName());
        }
    }

    private static void auditLogsComparison() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyy HH:mm");

        Date d = format.parse("12/10/2017 12:20");
        System.out.println(format.format(d));

        List<AuditLog> auditLogs = new ArrayList<>();
        List<AuditLog> auditLogs2 = new ArrayList<>();
        AuditLog log1 = new AuditLog(1, "Create", format.parse("12/10/2017 12:20") , null, "Jhon", null);
        AuditLog log2 = new AuditLog(2, "Create", format.parse("12/10/2017 12:21") , null, "Jhon", null);
        AuditLog log3 = new AuditLog(3, "Update", null, format.parse("12/10/2017 12:24"), null, "Jhon");
        AuditLog log4 = new AuditLog(4, "Update", null, format.parse("12/10/2017 12:25"), null, "Peter");
        AuditLog log5 = new AuditLog(5, "Update", null, format.parse("12/10/2017 12:25"), null, "Jhon");
        AuditLog log6 = new AuditLog(6, "Create", format.parse("12/10/2017 12:26") , null, "Peter", null);
        AuditLog log7 = new AuditLog(7, "Update", null,format.parse("12/10/2017 12:26"),null, "Peter");
        AuditLog log8 = new AuditLog(8, "Update", null,format.parse("12/10/2017 12:23"), null,"Peter");
        AuditLog log9 = new AuditLog(9, "Create",format.parse("12/10/2017 12:28"), null, "Jhon", null);
        AuditLog log10 = new AuditLog(10, "Update",format.parse("12/10/2017 12:28"), null,null, "Jhon");
        AuditLog log11 = new AuditLog(11, "Create", format.parse("12/10/2017 12:23"), null, "Jhon", null);

        auditLogs.add(log1);
        auditLogs.add(log2);
        auditLogs.add(log3);
        auditLogs.add(log4);
        auditLogs.add(log5);

        auditLogs2.add(log6);
        auditLogs2.add(log7);
        auditLogs2.add(log8);
        auditLogs2.add(log9);
        auditLogs2.add(log10);
        auditLogs2.add(log11);

        auditLogs.addAll(auditLogs2);

        Collections.sort(auditLogs);
        for(AuditLog log: auditLogs){
            System.out.print(" "+log.getId()+"\t "+log.getAction()+"\t ");
            if(log.getCreatedTimeStamp() != null)
                System.out.print(""+format.format(log.getCreatedTimeStamp())+"\tnull ");
            if(log.getModifiedTimeStamp() != null)
                System.out.print("null \t "+format.format(log.getModifiedTimeStamp()));
            System.out.print("\t "+log.getCreatedBy()+"\t "+log.getModifiedBy()+"\t ");
            System.out.println();

        }




    }
}

