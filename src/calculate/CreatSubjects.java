package calculate;

import java.io.*;

public class CreatSubjects {
    public void creatSubject(int number, int act) {

        System.out.println("---------四则运算----------");
        System.out.println("请选择操作");
        System.out.println("1.生成题目");
        System.out.println("2.进行批改");
        System.out.println("3.退出");
        if (act == 1) {
            for (int i = 0; i < number; i++) {
                BinaryTree bTree;
                bTree = new BinaryTree(2);
                bTree.createBTree();
                


                try {
                    FileWriter fileWriter1 = new FileWriter("src/Answers.txt", true);
                    fileWriter1.write("");
                    fileWriter1.write((i + 1) + ":");
                    fileWriter1.write(bTree.CalAndVal());
                    fileWriter1.write("\r\n");
                    fileWriter1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    FileWriter fileWriter = new FileWriter("src/Exam.txt", true);
                    fileWriter.write("");
                    fileWriter.write((i + 1) + ".");
                    fileWriter.write(bTree.toString());
                    fileWriter.write("=" + " " + "\r\n");
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (act == 2) {
            System.out.print("答题情况如下：");
            InputStreamReader reader = null;
            try {
                // String[] repeatExam = null;
                //int repeat = 0;
                String string1;
                int i = 0;
                String correct_string = "";//正确题号
                String wrong_string = "";//错误题号
                int wrong = 0;//定义错误个数
                int correct = 0;//定义正确个数

                reader = new InputStreamReader(
                        new FileInputStream(
                                "src/Answers.txt"), "gbk");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String string = null;
                InputStreamReader reader1 = new InputStreamReader(
                        new FileInputStream(
                                "src/Exam.txt"),
                        "gbk");
                BufferedReader bufferedReader1 = new BufferedReader(reader1);

                while (((string = bufferedReader.readLine()) != null)
                        && (string1 = bufferedReader1.readLine()) != null) {
                    i++;
                    String[] st = string.split(":");
                    String[] st1 = string1.split("=");


                    if (st[1].trim().equals(st1[1].trim())) {
                        correct++;
                        correct_string = correct_string + i + ",";
                    } else {
                        wrong++;
                        wrong_string = wrong_string + i + ",";
                    }

                }
                System.out.print("Correct:" + correct);//输出正确格式
                if (correct_string.length() <= 1)
                    System.out.println("(" + ")");
                else
                    System.out.println("("
                            + correct_string.substring(0, correct_string.length() - 1) + ")");

                System.out.print("Wrong:" + wrong);//输出错误格式
                if (wrong_string.length() <= 1)
                    System.out.println("(" + ")");
                else
                    System.out.println("("
                            + wrong_string.substring(0, wrong_string.length() - 1) + ")");


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (act == 3) {
            System.out.println("退出成功！");
        }

    }
}