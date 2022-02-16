package studentdatabaseapp;

import java.util.Scanner;
/*
  Aplicativo de banco de dados do aluno
  Cenário: Você é Administrador de Banco de Dados de uma universidade e precisa
  criar um aplicativo para gerenciar as matrículas e o saldo dos alunos.
 Sua inscrição deve fazer o seguinte:
 * Perguntar ao usuário quantos novos alunos serão adicionados ao banco de dados
 * O usuário deve ser solicitado a inserir o nome e o ano de cada aluno
 * O aluno deve ter um ID exclusivo de 5 dígitos, com o primeiro número sendo o nível de sua série
 * Um aluno pode se matricular nos seguintes cursos:
  - História 101
  - Matemática 101
  - Inglês 101
  - Química 101
  - Ciência da Computação 101
 * Cada curso custa R$ 600 para se matricular
 * O aluno deve poder ver seu saldo e pagar as mensalidades
 * Para ver o status do aluno, devemos ver seu nome, ID, cursos matriculados e saldo

 */
public class StudentDatabaseApp {

    public static void main(String[] args) {
        //Ask how many new users we want to add
        System.out.print("Insira número de novos alunos para inserir no banco de dados: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        Student[] students = new Student[numOfStudents];

        //Create n number of a new students
        for (int n = 0; n< numOfStudents; n++){
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();


        }
        for (int n = 0; n<numOfStudents;n++){
            System.out.println(students [n].toString());
        }

    }
}
