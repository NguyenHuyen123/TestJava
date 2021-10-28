package ex1_ex2.Test;

import ex1_ex2.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UnitTest {
    @Test
    @DisplayName("Same Data") // Dữ liệu giống nhau
    void sameData(){
        Student actual= new Student(18424005, "Đặng Văn Thường", "dvthuong@gmail.com", 0,0,0,4.5);
        Student expect= new Student(18424005, "Đặng Văn Thường", "dvthuong@gmail.com", 0,0,0,4.5);
        Assertions.assertEquals(expect, actual);
    }
    @Test
    @DisplayName("Ruond up") // Làm tròn lên
    void roundUp(){

        Student actual= new Student(18424005, "Đặng Văn Thường", "dvthuong@gmail.com", 0,0,0,7.37);
        double tb= actual.getTotalFinal();

       double expect= 3.5;
        Assertions.assertEquals(expect, tb);
    }
    @Test
    @DisplayName("Ruond down") // Làm tròn lên
    void roundDown(){

        Student actual= new Student(18424005, "Đặng Văn Thường", "dvthuong@gmail.com", 0,0,0,7.2);
        double tb= actual.getTotalFinal();
        double expect= 3.0;
        Assertions.assertEquals(expect, tb);
    }

}
