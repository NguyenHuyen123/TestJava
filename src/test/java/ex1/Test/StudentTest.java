package ex1.Test;

import ex1.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StudentTest {
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
        Student expect= new Student(18424005, "Đặng Văn Thường", "dvthuong@gmail.com", 0,0,0,7.5);
        Assertions.assertEquals(expect, actual);
    }

}
