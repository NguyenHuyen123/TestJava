package ex1;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RunApplication {

    public static void main(String[] args) {

        // Read data
        CSVSupport.ReadFileCSV("data.csv");
        // Sort LT
        List<Student> lstStudentSort = CSVSupport.getListStudentFromCSVFile("data.csv");
        Collections.sort(lstStudentSort, new Comparator<Student>() {
            @Override
            public int compare(Student c1, Student c2) {
                return Double.compare(c2.getLt(), c1.getLt());
            }
        });

        System.out.println("--------- Sắp xêp điểm lý thuyết giảm dần");
        for (Student student : lstStudentSort.subList(0, lstStudentSort.size() > 10 ? 9 : lstStudentSort.size())) {
            System.out.println(student.toString());
        }

        System.out.println("--------- Điểm tổng kết");
        for (Student student : lstStudentSort) {
            System.out.println("Tên SV: " + student.getName() + " , Điểm TB: " + student.getTotalFinal());
        }

        System.out.println("--------- 10 SV có điểm trung bình thấp nhất");
        List<Student> lstStudentTBSort = CSVSupport.getListStudentFromCSVFile("data.csv");
        Collections.sort(lstStudentTBSort, new Comparator<Student>() {
            @Override
            public int compare(Student c1, Student c2) {
                return Double.compare(c1.getTotalFinal(), c2.getLt());
            }
        });
        for (Student student : lstStudentTBSort.subList(0, lstStudentSort.size() > 10 ? 9 : lstStudentSort.size())) {
            System.out.println("Tên SV: " + student.getName() + " , Điểm TB: " + student.getTotalFinal());
        }

        System.out.println("--------- Xuất file CSV có điểm tổng kết");
        CSVSupport.ExportFileCSV("output.csv", lstStudentTBSort);
        System.out.println("--------- OK ! đã xuất thành công");

        System.out.println("--------- Thông kê ");
        System.out.println("Thông kê \t \t \t Số lượng \t Tỉ lệ");
        System.out.println("Tổng số sinh viên \t \t  " + lstStudentTBSort.size());
        int tbDat = lstStudentTBSort.stream().filter(s -> s.getTotalFinal() > 4.5).collect(Collectors.toList()).size();
        System.out.println("Đạt \t \t \t \t  " + tbDat + "\t \t" + tbDat * 100 / lstStudentTBSort.size() + "%");

        int tbKhonDat = lstStudentTBSort.stream().filter(s -> s.getTotalFinal() < 4.5).collect(Collectors.toList())
                .size();
        System.out.println("Không Đạt \t \t \t  " + tbKhonDat + "\t \t" + tbKhonDat * 100 / lstStudentTBSort.size() + "%");

        int tbGioi = lstStudentTBSort.stream()
                .filter(s -> s.getTotalFinal() < 10 && s.getTotalFinal() > 8).collect(Collectors.toList()).size();
        System.out.println("Giỏi \t \t \t \t  " + tbGioi + "\t \t" + tbGioi * 100 / lstStudentTBSort.size() + "%" );

        int tbKha = lstStudentTBSort.stream()
                .filter(s -> s.getTotalFinal() < 8 && s.getTotalFinal() > 6.5).collect(Collectors.toList()).size();
        System.out.println("Khá \t \t \t \t  " + tbKha  + "\t \t" + tbKha * 100 / lstStudentTBSort.size() + "%" );

        int tbTrungBinh = lstStudentTBSort.stream()
                .filter(s -> s.getTotalFinal() < 6.5 && s.getTotalFinal() > 5).collect(Collectors.toList()).size();
        System.out.println("Trung Bình \t \t \t  " + tbTrungBinh + "\t \t" + tbTrungBinh * 100 / lstStudentTBSort.size() + "%" );

        System.out.println("--------- Kiểm tra phải email Gmail hay Outlook (isVailEmail) & thống kê");
        // ^([\w.-]+)@|(?!gmail|outlook)(([a-zA-Z\d-]+\.)+)([a-zA-Z]{2,15}|\d{1,3})(\]?)$
        List<Student> lstStudentEmail = lstStudentTBSort.stream().filter(s -> s.isVailEmailGmail()).collect(Collectors.toList());
        for (Student student : lstStudentEmail ) {
            System.out.println(student.toString() );
        }

    }
}
