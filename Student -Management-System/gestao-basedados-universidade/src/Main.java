import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) {

        int prompt;
        File myfine = new File("std.bat");
        Scanner sc = new Scanner(System.in);
        if (myfine.length() > 0) {

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("std.bat"))) {
                Autenticacao.uniqueStudent = (HashMap<String, Student>) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.println("Para uma Nova entrada: PRESSIONE 1 \nPara manipular dados de entrada de aluno existente: PRESSIONE 2 " +
                    "\nSalvar e sair: PRESSIONE 3: ");
            prompt = sc.nextInt();
            sc.nextLine();

            switch (prompt) {
                case 1:
                    Student s1 = new Student();
                    System.out.println("Nome do aluno");
                    String temp = sc.nextLine();
                    s1.setName(temp);
                    System.out.println("Entrar com a nota do aluno");
                    int grade = sc.nextInt();
                    s1.setGrade(grade);
                    s1.setID();
                    Autenticacao.uniqueStudent.put(s1.getID(), s1);
                    System.out.println("Identificação única do aluno: " + s1.getID());
                    break;
                case 2:
                    System.out.println("ID aluno: ");
                    String str = sc.nextLine();

                    if (Autenticacao.uniqueStudent.containsKey(str)) {
                        Student objective = Autenticacao.uniqueStudent.get(str);
                        System.out.println("Nome do aluno:  " + objective.getName() + "\nNota do aluno: " + objective.getGrade());
                        System.out.println("As disciplinas cursadas pelo aluno são");
                        ArrayList<Courses> c = objective.getCourses();
                        if (c != null) {
                            for (Courses cr : c) {
                                System.out.println(cr.toString());
                            }
                        }
                        else if(c==null){
                            System.out.println("O aluno não se matriculou em nenhum curso ");
                        }
                        System.out.println("O saldo da conta dos alunos é" + objective.getTotalMoney());

                        if (objective.getTotalMoney() >= 800) {
                            System.out.println("Você tem dinheiro suficiente: " + (objective.getTotalMoney() / 800) + " mais cursos");

                            System.out.println("Gostaria de matricular em outros cursos? \nDigite 1 para sim \n" +
                                    "Digite 2 para não");

                            int token = sc.nextInt();
                            sc.nextLine();
                            if (token == 1) {

                                HashSet<Courses> allCourses = new HashSet<>();

                                for (Courses cs : Courses.values()) {
                                    allCourses.add(cs);
                                }
                                if (c != null) allCourses.removeAll(c);
                                System.out.println("Selecione um dos seguintes cursos: ");

                                for (Courses course : allCourses) {
                                    System.out.println(course);
                                }

                                String stringu=sc.nextLine();
                                Courses crs=null;
                                try {
                                    crs=Courses.valueOf(stringu);
                                }
                                catch (IllegalArgumentException e){
                                    System.out.println("Entre com um valor válido! Digite novamente!");
                                    continue;
                                }

                                System.out.println("Debugging "+crs);
                                objective.addSubject(crs);
                                System.out.println("O Aluno tem: ");
                                for(Courses cs: objective.getCourses()){
                                    System.out.println(cs);
                                }
                            }

                        }


                    } else {
                        System.out.println("Identificação Inválida");

                    }
                    break;
                case 3:
                    try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("std.bat"))) {
                        ois.writeObject(Autenticacao.uniqueStudent);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Salvar e sair");
                    return;

            }

        }

    }
}