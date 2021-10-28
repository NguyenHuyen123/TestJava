package ex1_ex2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
public class CSVSupport {
    private static final String COMMA_DELIMITER = ",";

    public static List<Student> getListStudentFromCSVFile(String fileName) throws NumberFormatException {
        List<Student> lstStudent = new ArrayList<Student>();

        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            int counter = 0;
            while ((line = br.readLine()) != null) {
                if (counter == 0) {
                    counter++;
                    continue;
                }

                if (line != null) {
                    String[] splitData = line.split(COMMA_DELIMITER);
                    long id = Long.parseLong(splitData[0]);
                    String name = splitData[1];
                    String email = splitData[2];
                    int bonus = Integer.parseInt(splitData[3]);
                    int report = Integer.parseInt(splitData[4]);
                    ;
                    int app = Integer.parseInt(splitData[5]);
                    ;
                    double lt = Double.parseDouble(splitData[6]);
                    lstStudent.add(new Student(id, name, email, bonus, report, app, lt));
                }
                counter++ ;
            }

        } catch (

                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }

        return lstStudent;
    }

    public static void ReadFileCSV(String fileName) {

        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

            while ((line = br.readLine()) != null) {
                printContry(parseCsvLine(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static void ExportFileCSV(String name, List<Student> lstData) {

        Writer out;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
            bw.write("ID");
            bw.write(",");
            bw.write("Name");
            bw.write(",");
            bw.write("Email");
            bw.write(",");
            bw.write("Bonus");
            bw.write(",");
            bw.write("Report");
            bw.write(",");
            bw.write("App");
            bw.write(",");
            bw.write("LT");
            bw.write(",");
            bw.write("DTB");
            bw.newLine();
            for (Student s : lstData) {
                List<String> data = new ArrayList<String>();
                data.add(s.getId() + "");
                data.add(s.getName() + "");
                data.add(s.getEmail() + "");
                data.add(s.getBonus() + "");
                data.add(s.getReport() + "");
                data.add(s.getApp() + "");
                data.add(s.getLt() + "");
                data.add(s.getTotalFinal() + "");
                bw.write(String.join(",", data));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    private static void printContry(List<String> data) {
        System.out.println(data.get(0) + "," + data.get(1) + "," + data.get(2) + "," + data.get(3) + "," + data.get(4)
                + "," + data.get(5) + "," + data.get(6));
    }
}
