package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = null;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int  id = 1000;

    //Constructor: prompt user to enter student´s name and year
    public  Student(){
        Scanner in = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        this.firstName = in.nextLine();

        System.out.print("Digite seu Sobrenome: ");
        this.lastName = in.nextLine();

        System.out.print("1 - 1º ano\n2 - 2º ano\n3 - 3º ano\n4 - 4º ano\n Digite o semestre: ");
        this.gradeYear = in.nextInt();

        setStudentID();

        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);

    }

    //Generate an ID

    private  void setStudentID(){
        //Grade level + ID
        id++;
        this.studentID = gradeYear + " " + id;
    }

    //Enroll in courses
    public  void enroll() {
        //Get inside a loop, user hits 0
        do {
            System.out.print("Entrar no curso para se inscrever (S para sair): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("S")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }

        } while (1 != 0);

    }
    //View balance
    public void viewBalance(){
        System.out.println("Saldo: R$" + tuitionBalance);
    }

    //Pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Digite seu pagamento: R$");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Obrigado(a) pelo pagamento de R$" + payment);
        viewBalance();
    }

    //show status
    public String toString(){
        return "Nome: " + firstName + " " + lastName +
                "\nNota: " + gradeYear +
                "\nID Aluno: " + studentID +
                "\nCursos Inscritos: " + courses +
                "\nSaldo: $" + tuitionBalance;
    }


}
