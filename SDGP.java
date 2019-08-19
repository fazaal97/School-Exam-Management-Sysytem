import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;
import java.util.Scanner;


public class SDGP {

    public static ArrayList<Student> studentList = new ArrayList<>();
    static int totalICT1 = 0;
    static int totalICT2 = 0;
    static int totalCWK1 = 0;
    static int totalCWK2 = 0;
    static int moduleTotal = 0;
    static int count = 0;
    static int min = 100;
    static int max = 0;


    static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        System.out.println("\n");
        System.out.println("Hello , Welcome ");
        System.out.println("_________________________________________________________________ ");
        System.out.println("| 1. Add student marks                                           |");
        System.out.println("| 2. Find the class average by component                         |");
        System.out.println("| 3. Find the below 30 marks by component                        |");
        System.out.println("| 4. Find the module average  marks of class                     |");
        System.out.println("| 5. Student details whose marks are below overall class average |");
        System.out.println("| 6. Student marks list above overall class average              |");
        System.out.println("| 7. Module Lowest scorer                                        |");
        System.out.println("| 8. Module Highest scorer                                       |");
        System.out.println("| 9. Histogram                                                   |");
        System.out.println("| 10. Exit                                                       |");
        System.out.println("_________________________________________________________________ ");


        System.out.print("Select your Option : ");

        if (Sc.hasNextInt()) {
            boolean res = false;
            int i = Sc.nextInt();
            switch (i) {
                case 1:
                    enterMarks();
                    break;
                case 2:
                    if (studentList.isEmpty()) {
                        res = true;
                    } else {
                        findAverage();
                        break;
                    }
                case 3:
                    if (studentList.isEmpty()) {
                        res = true;
                    } else {
                        below30();
                        menu();
                        break;
                    }

                case 4:
                    if (studentList.isEmpty()) {
                        res = true;
                    } else {
                        moduleAverage();
                        break;
                    }
                case 5:
                    if (studentList.isEmpty()) {
                        res = true;
                    } else {
                        belowOverallAvarage();
                        break;
                    }

                case 6:
                    if (studentList.isEmpty()) {
                        res = true;
                    } else {
                        aboveOverallAvarage();
                        break;
                    }

                case 7:
                    if (studentList.isEmpty()) {
                        res = true;
                    } else {
                        findMin();
                        break;
                    }

                case 8:
                    if (studentList.isEmpty()) {
                        res = true;
                    } else {
                        findMax();
                        break;
                    }
                case 9:
                    if (studentList.isEmpty()) {
                        res = true;
                    } else {
                        new Output().setVisible(true);
                        Sc = new Scanner(System.in);
                        menu();
                        break;
                    }
                case 10:
                    break;
                default:
                    Sc = new Scanner(System.in);
                    menu();
                    break;
            }
            if (res) {
                System.out.print("Please add Student Details First. Thank You!");
                menu();
            }
        } else {
            System.out.print("Please enter an number!");
            Sc = new Scanner(System.in);
            menu();
        }
    }

    private static void below30() {
        StringBuilder result;
        for (Student s : studentList) {
            result = new StringBuilder();
            if (s.getmarksICT1() < 30) {
                result.append("ICT1 | ");
            }
            if (s.getmarksICT2() < 30) {
                result.append("ICT2 | ");
            }
            if (s.getmarksCWK1() < 30) {
                result.append("CWK1 | ");
            }
            if (s.getmarksCWK2() < 30) {
                result.append("CWK2 | ");
            }
            System.out.println(s.getfName() + " " + s.getlName() + " : " + result);
        }
    }


    public static void enterMarks() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter Student's First name :");
        String fname = Sc.next();

        System.out.println("Enter Student Last name :");
        String lname = Sc.next();

        System.out.println("Enter Student Registration No :");
        String rNo = Sc.next();
        int a = getMarks(sc, "Enter Student ICT 01 marks :");
        int b = getMarks(sc, "Enter Student ICT 02 marks :");
        int c = getMarks(sc, "Enter Student CWK 01 marks :");
        int d = getMarks(sc, "Enter Student CWK 02 marks :");


        int comp1mark = (a + b) / 2;
        int comp2mark = (c + d) / 2;

        int marks = (int) Math.round((comp1mark * 0.4 + c * 0.6));
        totalICT1 = totalICT1 + a;
        totalICT2 = totalICT2 + b;
        totalCWK1 = totalCWK1 + c;
        totalCWK2 = totalCWK2 + d;
        moduleTotal = moduleTotal + marks;
        count++;

        if (marks < min) {
            min = marks;
        }

        if (marks > max) {
            max = marks;
        }

        Student student = new Student(rNo, rNo, rNo, d, d, d, d);
        student.setfName(fname);
        student.setlName(lname);
        student.setNo(rNo);
        student.setmarksICT1(a);
        student.setmarksICT2(b);
        student.setmarksCWK1(c);
        student.setmarksCWK2(d);
        student.setcomponent1marks(comp1mark);
        student.setcomponent2marks(comp2mark);
        student.settotalMarks(marks);
        student.setGrade(marks);


        studentList.add(student);


        for (int i = 0; i < studentList.size(); i++) {

            Student s = studentList.get(i);


            System.out.println("Student First Name: " + s.getfName());
            System.out.println("Student Last Name: " + s.getlName());
            System.out.println("Registration No: " + s.getNo());
            System.out.println("ICT 01 marks: " + s.getmarksICT1());
            System.out.println("ICT 02 marks: " + s.getmarksICT2());
            System.out.println("Course work 01 marks: " + s.getmarksCWK1());
            System.out.println("Course work 02 marks: " + s.getmarksCWK2());
            System.out.println("Component 01 marks: " + s.getcomponent1marks());
            System.out.println("Component 02 marks: " + s.getcomponent2marks());
            System.out.println("Final marks: " + s.gettotalMarks());
            System.out.println("Student Grade: " + s.getGrade());

            System.out.println("");

        }
        menu();
    }

    private static int getMarks(Scanner sc, String message) {
        int marks;
        do {
            System.out.println(message);

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input please enter a "
                        + "number within the range of 0 to 100");
                sc.next();
            }

            marks = sc.nextInt();
            if (!(marks >= 0 && marks <= 100)) {
                System.out.println("Invalid Marks!!! it has be within the range of 0 to 100 ");
            }

        } while (marks < 0 || marks > 100);
        return marks;
    }


    static void findAverage() {

        int ICT1Average = totalICT1 / count;
        int ICT2Average = totalICT2 / count;
        int CWK1Average = totalCWK1 / count;
        int CWK2Average = totalCWK2 / count;

        System.out.println("Average ICT 01 marks: " + ICT1Average);
        System.out.println("Average ICT 02 marks: " + ICT2Average);
        System.out.println("Average CWK 01 marks: " + CWK1Average);
        System.out.println("Average CWK 02 marks: " + CWK2Average);
        menu();
    }


    static void moduleAverage() {

        int moduleAverage = moduleTotal / count;
        System.out.println("Module Average: " + moduleAverage);
        menu();
    }

    static void belowOverallAvarage() {
        int moduleAverage = moduleTotal / count;
        for (Student s : studentList) {
            if (moduleAverage > s.gettotalMarks()) {
                System.out.println(s.getfName() + " " + s.getlName() + " : " + s.gettotalMarks());
            }
        }
        menu();
    }

    static void aboveOverallAvarage() {
        int moduleAverage = moduleTotal / count;
        ArrayList<Student> aboveAvarageStudentList = new ArrayList<>();
        for (Student s : studentList) {
            if (moduleAverage < s.gettotalMarks()) {
                aboveAvarageStudentList.add(s);
            }
        }
        Collections.sort(studentList, new MarksSorter());
        for (Student student : aboveAvarageStudentList) {
            System.out.println(student.toString());
        }

        menu();
    }


    static void findMin() {


        System.out.println("Minimum Module marks: " + min);
        menu();
    }

    static void findMax() {


        System.out.println("Maximum Module marks: " + max);

        menu();
    }


    static public List<Student> sort(Student[] arr) {
        int n = arr.length;
        Student temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        List<Student> list = Arrays.asList(arr);

        return list;

    }

    //JFrame

    public static class Output extends javax.swing.JFrame {

        public Output() {
            initComponents();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            jLabel1 = new javax.swing.JLabel();
            jl029 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jl3039 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jl4069 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            jl70100 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();
            jLabel2 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jloam = new javax.swing.JLabel();
            jlhm = new javax.swing.JLabel();
            jllm = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel1.setText("0,29");

            jl029.setText("-----");
            jl029.setName("029"); // NOI18N

            jLabel3.setText("30,39");

            jl3039.setText("-------");
            jl3039.setName("3049"); // NOI18N

            jLabel5.setText("40,69");

            jl4069.setText("-----");

            jLabel7.setText("70,100");

            jl70100.setText("-----");

            jButton1.setText("Show");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jLabel2.setText("Overall Avarage Mark :");

            jLabel6.setText("Highest Mark :");

            jLabel8.setText("Lowest Mark");

            jloam.setText("jLabel4");

            jlhm.setText("jLabel9");

            jllm.setText("jLabel10");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel1)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jLabel3)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jLabel5)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(jLabel7))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jl029)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jl3039)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jl4069, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(jl70100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel6)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(jlhm))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel8)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(jllm))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel2)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(jloam)))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel1)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jLabel7))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jl3039, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jl029, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jl70100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(jl4069, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jloam))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(jlhm))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(jllm))
                                    .addGap(37, 37, 37))
            );

            jl029.getAccessibleContext().setAccessibleName("029");
            jl3039.getAccessibleContext().setAccessibleName("3049");

            pack();
        }// </editor-fold>

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            String l029 = "<html>";
            String l3039 = "<html>";
            String l4069 = "<html>";
            String l70100 = "<html>";
            for (Student student : studentList) {
                if (student.gettotalMarks() >= 0 && student.gettotalMarks() <= 29) {
                    l029 += "*<br>";
                }else if (student.gettotalMarks() >= 30 && student.gettotalMarks() <= 39) {
                    l3039 += "*<br>";
                }else if (student.gettotalMarks() >= 40 && student.gettotalMarks() <= 69) {
                    l4069 += "*<br>";
                }else if (student.gettotalMarks() >= 70 && student.gettotalMarks() <= 100) {
                    l70100 += "*<br>";
                }
            }
            l029 += "</html>";
            l3039 += "</html>";
            l4069 += "</html>";
            l70100 += "</html>";

            jl029.setText(l029);
            jl3039.setText(l3039);
            jl4069.setText(l4069);
            jl70100.setText(l70100);

            int moduleAverage = moduleTotal / count;
            jloam.setText(String.valueOf(moduleAverage));
            jlhm.setText(String.valueOf(max));
            jllm.setText(String.valueOf(min));
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jl029;
        private javax.swing.JLabel jl3039;
        private javax.swing.JLabel jl4069;
        private javax.swing.JLabel jl70100;
        private javax.swing.JLabel jlhm;
        private javax.swing.JLabel jllm;
        private javax.swing.JLabel jloam;
        // End of variables declaration
    }

}